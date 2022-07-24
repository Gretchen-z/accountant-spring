package ru.gretchen.accountantspring.mapper;

import ru.gretchen.accountantspring.model.Report;
import ru.gretchen.accountantspring.model.User;
import ru.gretchen.accountantspring.model.dto.ReportDTO;
import ru.gretchen.accountantspring.model.dto.TaskDTO;
import ru.gretchen.accountantspring.model.dto.TeamReportDTO;
import ru.gretchen.accountantspring.model.dto.UserReportDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс с логикой маппинга Report в ReportDTO
 */
public abstract class ReportMapperDecorator implements ReportMapper {

    private final ReportMapper delegate;

    public ReportMapperDecorator(ReportMapper delegate) {
        this.delegate = delegate;
    }

    /**
     * Метод для маппинга Report в ReportDTO
     * @param report
     * @param users
     * @return ReportDTO
     */
    @Override
    public ReportDTO fromEntity(Report report, List<User> users) {
        ReportDTO reportDTO = delegate.fromEntity(report);

        users.stream().filter(u-> Objects.isNull(u.getGroup())).forEach(u-> u.setGroup("Без команды"));

        List<String> teams = users.stream().map(User::getGroup).distinct().collect(Collectors.toList());

        Map<String, List<User>> userTeamMap = users.stream().collect(Collectors.groupingBy(User::getGroup));

        reportDTO.setTeamReports(getTeamReports(report, teams, userTeamMap));
        return reportDTO;
    }

    /**
     * Метод для маппинга списка Team в список TeamReportDTO
     * @param report
     * @param teams
     * @param userTeamMap
     * @return List<TeamReportDTO>
     */
    private List<TeamReportDTO> getTeamReports(Report report, List<String> teams, Map<String, List<User>> userTeamMap){
        List<TeamReportDTO> result = new ArrayList<>();

        teams.forEach(team -> {
            TeamReportDTO teamReportDTO = new TeamReportDTO();
            teamReportDTO.setTeamName(team);

            teamReportDTO.setUserReports(getUserReports(report, userTeamMap.get(team)));
            result.add(teamReportDTO);
        });

        return result;
    }

    /**
     * Метод для маппинга списка User в список UserReportDTO
     * @param report
     * @param teamUsers
     * @return List<TeamReportDTO>
     */
    private List<UserReportDTO> getUserReports(Report report, List<User> teamUsers) {
        return teamUsers.stream().map(user -> {
            UserReportDTO userReportDTO = new UserReportDTO();
            userReportDTO.setFullName(user.getFullName());

            List<TaskDTO> tasksByUser = report.getTasks().stream()
                    .filter(t -> t.getChatId().equals(user.getChatId()))
                    .map(delegate::fromEntityToTask)
                    .collect(Collectors.toList());

            userReportDTO.setTasks(tasksByUser);
            return userReportDTO;
        }).collect(Collectors.toList());
    }
}
