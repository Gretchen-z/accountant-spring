package ru.gretchen.accountantspring.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.gretchen.accountantspring.model.Report;
import ru.gretchen.accountantspring.model.Task;
import ru.gretchen.accountantspring.model.User;
import ru.gretchen.accountantspring.model.dto.ReportDTO;
import ru.gretchen.accountantspring.model.dto.TaskDTO;

import java.util.List;

/**
 * Interface для маппинга сущности Report в ReportDTO
 */
@Mapper
@DecoratedWith(ReportMapperDecorator.class)
public interface ReportMapper {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    @Mapping(target = "date", source = "date")
    ReportDTO fromEntity(Report entity);

    ReportDTO fromEntity(Report entity, List<User> users);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "timeInMinutes", source = "timeInMinutes")
    TaskDTO fromEntityToTask(Task entity);
}
