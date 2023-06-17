package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.ReportRepository;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final ObjectMapper objectMapper;

    public ReportService(ReportRepository reportRepository, ObjectMapper objectMapper) {
        this.reportRepository = reportRepository;
        this.objectMapper = objectMapper;
    }

    private List<ReportDTO> createReport() {
        return 
    }
}
