package ru.skypro.lessons.springboot.EmployeeApplication.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReportDTO {
    private String report;
}
