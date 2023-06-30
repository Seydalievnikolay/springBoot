package ru.skypro.lessons.springboot.EmployeeApplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public Double getMinimumSalaryEmployeeInDepartment(int departmentId) {
        logger.info("Was invoked method for getMinimumSalaryEmployeeInDepartment: {}",departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        logger.error("This no department with id = " + departmentId);
        Double aDouble = departmentEntity.getEmployees().stream()
                .mapToDouble(EmployeeEntity::getSalary)
                .min()
                .orElse(0.0);
        logger.debug("The minimum salary {} employee in department {}", aDouble, departmentId);
        return aDouble;
    }

    public Double getMaximumSalaryEmployeeInDepartment(int departmentId) {
        logger.info("Was invoked method for getMaximumSalaryEmployeeInDepartment: {}",departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        logger.error("This no department with id = " + departmentId);
        Double aDouble = departmentEntity.getEmployees().stream()
                .mapToDouble(EmployeeEntity::getSalary)
                .max()
                .orElse(0.0);
        logger.debug("The maximum salary {} employee in department {}", aDouble, departmentId);
        return aDouble;
    }

    public Double getEmployeesSalaryAboveAverageInDepartment(int departmentId) {
        logger.info("Was invoked method for getEmployeesSalaryAboveAverageInDepartment: {}",departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        logger.error("This no department with id = " + departmentId);
        Double aDouble = departmentEntity.getEmployees().stream()
                .mapToDouble(EmployeeEntity::getSalary)
                .average()
                .orElse(0.0);
        logger.debug("The average salary {} employee in department {}", aDouble, departmentId);
        return aDouble;
    }
    public int getAmountEmployeeInDepartment(int departmentId) {
        logger.info("Was invoked method for getAmountEmployeeInDepartment: {}",departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Введены неверные данные"));
        logger.error("This no department with id = " + departmentId);
        Integer amount = departmentEntity.getEmployees().size();
        logger.debug("The amount {} employee in department {}", amount, departmentId);
        return amount;
    }

    public List<DepartmentEntity> getAllDepartmentEntity() {
        logger.info("Was invoked method for getAllDepartmentEntity");
        List<DepartmentEntity> department = departmentRepository.findAll();
        logger.debug("All employees in department");
        return department;
    }



}
