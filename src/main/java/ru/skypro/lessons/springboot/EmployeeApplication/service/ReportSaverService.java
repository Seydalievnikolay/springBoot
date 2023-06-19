package ru.skypro.lessons.springboot.EmployeeApplication.service;

import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;

public interface ReportSaverService {
    ReportEntity saveReport(ReportEntity reportEntity);
}
