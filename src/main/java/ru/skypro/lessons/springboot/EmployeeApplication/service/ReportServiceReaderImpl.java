package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportToFileJsonDTO;

import java.io.File;
import java.io.IOException;

@Service
public class ReportServiceReaderImpl implements ReportReaderService{
    @Override
    public ReportToFileJsonDTO readerReport(ReportDTO reportDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(reportDTO.getPath());
        ReportToFileJsonDTO reportToFileJsonDTO = null;
        try {
            reportToFileJsonDTO = objectMapper.readValue(file, ReportToFileJsonDTO.class);
        } catch (IOException e) {
            e.getMessage();
        }
        return reportToFileJsonDTO;
    }
}
