package ru.skypro.lessons.springboot.EmployeeApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportToFileJsonDTO {
    private String fileInfo;
}
