package ru.gretchen.accountantspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDTO {
    private LocalDate date;
    List<TeamReportDTO> teamReports;
}
