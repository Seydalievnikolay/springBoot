package ru.skypro.lessons.springboot.EmployeeApplication.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportToFileJsonDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;

@Service
public interface ReportReaderService {
    ReportToFileJsonDTO readerReport (ReportDTO reportDTO);
}
