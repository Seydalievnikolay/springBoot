package ru.skypro.lessons.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Double getMinimumSalaryEmployeeInDepartment(int departmentId) {
        return null;
    }

    public Double getMaximumSalaryEmployeeInDepartment(int departmentId) {
        return null;
    }

    public Double getEmployeesSalaryAboveAverageInDepartment(int departmentId) {
        return null;
    }
    public int getAmountEmployeeInDepartment(int departmentId) {
        return  0;
    }



}
