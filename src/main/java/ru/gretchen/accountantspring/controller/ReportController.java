package ru.gretchen.accountantspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gretchen.accountantspring.mapper.ReportMapper;
import ru.gretchen.accountantspring.model.Report;
import ru.gretchen.accountantspring.model.Task;
import ru.gretchen.accountantspring.model.User;
import ru.gretchen.accountantspring.model.dto.ReportDTO;
import ru.gretchen.accountantspring.service.ReportService;
import ru.gretchen.accountantspring.soap.SOAPService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с Report
 * endpoint /accountant/reports
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/reports")
public class ReportController{

    private final ReportService reportService;
    private final SOAPService soapService;

    /**
     * Метод отправляет в ответ на запрос сервиса-отправителя
     * сформированный Report в формате JSON.
     * В процессе формирования отчёта обращается к сервису-команде
     * для получения информации о User, нужной для Report.
     * @return ReportDTO
     */
    @GetMapping
    public ReportDTO get() {
        ReportMapper mapper = ReportMapper.INSTANCE;
        Report report = reportService.create();

        List<String> chatIds = report.getTasks().stream()
                .map(Task::getChatId)
                .distinct()
                .collect(Collectors.toList());

        List<User> users = soapService.requestUserByChatId(chatIds);

        ReportDTO reportDTO = mapper.fromEntity(report, users);

        return reportDTO;
    }
}
