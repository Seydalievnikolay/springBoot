package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ReportService {
    private final ReportRepository reportRepository;
    private final DepartmentService departmentService;
    private final ReportSaverService reportSaverServiceToJson;
    private final ReportSaverService reportSaverServiceToDB;

    public ReportService(ReportRepository reportRepository, DepartmentService departmentService,
                         @Qualifier("reportSaverServiceToJsonImpl") ReportSaverService reportSaverServiceToJson,
                         @Qualifier("reportSaverServiceToDBImpl") ReportSaverService reportSaverServiceToDB) {
        this.reportRepository = reportRepository;
        this.departmentService = departmentService;
        this.reportSaverServiceToJson = reportSaverServiceToJson;
        this.reportSaverServiceToDB = reportSaverServiceToDB;
    }

    public int saveReportToJsonAndDB() {
        ReportEntity report = createReport();
        reportSaverServiceToJson.saveReport(report);
        ReportEntity saveReport = reportSaverServiceToDB.saveReport(report);
        return saveReport.getId();
    }

    public ReportEntity createReport() {
        List<DepartmentEntity> departmentEntityList = departmentService.getAllDepartmentEntity();
        ReportEntity reportEntity = new ReportEntity();
        StringBuilder stringBuilder = new StringBuilder();
        departmentEntityList.forEach(departmentEntity -> {
            String nameOfDepartment = departmentEntity.getName();
            Integer amountOfEmployees = departmentService.getAmountEmployeeInDepartment(departmentEntity.getId());
            Double minSalary = departmentService.getMinimumSalaryEmployeeInDepartment(departmentEntity.getId());
            Double avgSalary = departmentService.getEmployeesSalaryAboveAverageInDepartment(departmentEntity.getId());
            Double maxSalary = departmentService.getMaximumSalaryEmployeeInDepartment(departmentEntity.getId());
            stringBuilder.append(String.format("Department: %s\n",nameOfDepartment));
            stringBuilder.append(String.format("Amount of employees: %s\n",amountOfEmployees));
            stringBuilder.append(String.format("Minimum salary: %s\n",minSalary));
            stringBuilder.append(String.format("Average salary: %s\n",avgSalary));
            stringBuilder.append(String.format("Maximum salary: %s\n",maxSalary));
        });
    reportEntity.setReportInfo(stringBuilder.toString());
    return  reportEntity;
    }

}
