package ru.skypro.lessons.springboot.EmployeeApplication.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.mappers.DepartmentMapper;
import ru.skypro.lessons.springboot.EmployeeApplication.model.DepartmentEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.model.EmployeeEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public Double getMinimumSalaryEmployeeInDepartment(int departmentId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        return departmentEntity.getEmployees().stream()
                .mapToDouble(EmployeeEntity::getSalary)
                .min()
                .orElse(0.0);
    }

    public Double getMaximumSalaryEmployeeInDepartment(int departmentId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        return departmentEntity.getEmployees().stream()
                .mapToDouble(EmployeeEntity::getSalary)
                .max()
                .orElse(0.0);
    }

    public Double getEmployeesSalaryAboveAverageInDepartment(int departmentId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        return departmentEntity.getEmployees().stream()
                .mapToDouble(EmployeeEntity::getSalary)
                .average()
                .orElse(0.0);
    }
    public int getAmountEmployeeInDepartment(int departmentId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        return departmentEntity.getEmployees().size();
    }

    public List<DepartmentEntity> getAllDepartmentEntity() {
        return departmentRepository.findAll();
    }



}
