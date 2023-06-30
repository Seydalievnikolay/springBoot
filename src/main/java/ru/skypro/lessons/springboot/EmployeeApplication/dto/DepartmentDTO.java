package ru.skypro.lessons.springboot.EmployeeApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String name;
    private EmployeeDTO employeeDTO;
}
