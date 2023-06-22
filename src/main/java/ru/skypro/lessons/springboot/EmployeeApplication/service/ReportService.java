package ru.skypro.lessons.springboot.EmployeeApplication.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.mappers.ReportMapper;
import ru.skypro.lessons.springboot.EmployeeApplication.model.DepartmentEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.ReportRepository;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final DepartmentService departmentService;
    private final ReportSaverService reportSaverServiceToJson;
    private final ReportSaverService reportSaverServiceToDB;
    private final ReportMapper reportMapper;

    public ReportService(ReportRepository reportRepository, DepartmentService departmentService,
                         @Qualifier("reportSaverServiceToJsonImpl") ReportSaverService reportSaverServiceToJson,
                         @Qualifier("reportSaverServiceToDBImpl") ReportSaverService reportSaverServiceToDB,
                         ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.departmentService = departmentService;
        this.reportSaverServiceToJson = reportSaverServiceToJson;
        this.reportSaverServiceToDB = reportSaverServiceToDB;
        this.reportMapper = reportMapper;
    }

    public int saveReportToJsonAndDB() {
        ReportDTO report = createReport();
        reportSaverServiceToJson.saveReport(report);
        ReportDTO saveReport = reportSaverServiceToDB.saveReport(report);
        return saveReport.getId();
    }

    public ReportDTO createReport() {
        List<DepartmentEntity> departmentEntityList = departmentService.getAllDepartmentEntity();
        ReportDTO reportDTO = new ReportDTO();
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
    reportDTO.setReport(stringBuilder.toString());
    return  reportDTO;
    }

    public ReportDTO getReportById(int id) {
        ReportEntity report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Отчет не найден"));
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setPath(report.getFilePath());
        return reportDTO;
    }

}
