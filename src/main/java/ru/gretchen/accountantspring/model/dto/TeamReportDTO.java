package ru.gretchen.accountantspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamReportDTO {
    private String teamName;
    private List<UserReportDTO> userReports;
}
