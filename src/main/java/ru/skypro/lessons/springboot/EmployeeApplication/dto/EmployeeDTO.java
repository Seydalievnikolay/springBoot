package ru.skypro.lessons.springboot.EmployeeApplication.dto;

import lombok.Builder;
import lombok.Data;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.Collection;
import java.util.List;

@Builder
@Data
public class EmployeeDTO {
    private String name;
    private double salary;
    private String position;
    List<Employee> employees;
}
