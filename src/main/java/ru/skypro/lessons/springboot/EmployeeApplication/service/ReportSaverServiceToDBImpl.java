package ru.skypro.lessons.springboot.EmployeeApplication.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.mappers.ReportMapper;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.ReportRepository;

@Service
public class ReportSaverServiceToDBImpl implements ReportSaverService {
    private final ReportRepository reportRepository;

    public ReportSaverServiceToDBImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportDTO saveReport(ReportDTO reportDTO) {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setFilePath(reportDTO.getPath());
        ReportEntity report = reportRepository.save(reportEntity);
        return ReportDTO.builder()
                .path(reportDTO.getReport())
                .path(report.getFilePath())
                .build();
    }
}
