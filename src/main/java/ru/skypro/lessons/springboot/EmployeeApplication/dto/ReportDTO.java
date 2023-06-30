package ru.skypro.lessons.springboot.EmployeeApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    private int id;
    private String report;
    private String path;
}
