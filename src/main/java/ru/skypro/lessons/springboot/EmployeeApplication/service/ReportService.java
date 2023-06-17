package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.DepartmentEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.DepartmentRepository;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.ReportRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final ObjectMapper objectMapper;
    private final DepartmentService departmentService;

    public int createReport() {
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        Map<String,ReportEntity> reportMap=new HashMap<>();
        for (DepartmentEntity departmentEntity : departmentEntityList) {
            String nameOfDepartment = departmentEntity.getName();
            Integer amountOfEmployees = departmentService.getAmountEmployeeInDepartment(departmentEntity.getId());
            Double minSalary = departmentService.getMinimumSalaryEmployeeInDepartment(departmentEntity.getId());
            Double avgSalary = departmentService.getEmployeesSalaryAboveAverageInDepartment(departmentEntity.getId());
            Double maxSalary = departmentService.getMaximumSalaryEmployeeInDepartment(departmentEntity.getId());
            ReportEntity reportEntity = ReportEntity.builder()
                    .departmentName(nameOfDepartment)
                    .numberOfEmployees(amountOfEmployees)
                    .minSalary(minSalary)
                    .averageSalary(avgSalary)
                    .maxSalary(maxSalary)
                    .build();
            reportMap.put(reportEntity.getDepartmentName(),reportEntity);
        }
        for (ReportEntity report : reportMap.values()) {
            reportRepository.save(report);
        }

    }
}
