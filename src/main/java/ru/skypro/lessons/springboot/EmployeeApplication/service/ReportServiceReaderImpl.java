package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportToFileJsonDTO;

import java.io.File;
import java.io.IOException;

@Service
public class ReportServiceReaderImpl implements ReportReaderService{
    Logger logger = LoggerFactory.getLogger(ReportServiceReaderImpl.class);
    @Override
    public ReportToFileJsonDTO readerReport(ReportDTO reportDTO) {
        logger.info("The method of reading the report was called");
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(reportDTO.getPath());
        ReportToFileJsonDTO reportToFileJsonDTO = null;
        try {
            reportToFileJsonDTO = objectMapper.readValue(file, ReportToFileJsonDTO.class);
        } catch (IOException e) {
            logger.error("Report not found" + e);
            e.getMessage();
        }
        logger.debug("The report has been read successfully" + reportDTO);
        return reportToFileJsonDTO;
    }
}
