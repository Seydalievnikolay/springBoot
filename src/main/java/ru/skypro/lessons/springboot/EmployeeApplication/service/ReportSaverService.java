package ru.skypro.lessons.springboot.EmployeeApplication.service;

import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;

public interface ReportSaverService {
    ReportDTO saveReport(ReportDTO reportDTO);
}
