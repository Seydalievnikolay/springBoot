package ru.skypro.lessons.springboot.EmployeeApplication.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.ReportRepository;

@Service
public class ReportSaverServiceToDBImpl implements ReportSaverService {
    private final ReportRepository reportRepository;

    public ReportSaverServiceToDBImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportEntity saveReport(ReportEntity reportEntity) {
        return reportRepository.save(reportEntity);
    }
}
