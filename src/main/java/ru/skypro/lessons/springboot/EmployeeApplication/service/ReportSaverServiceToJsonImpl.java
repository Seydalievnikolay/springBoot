package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;

@Service
public class ReportSaverServiceToJsonImpl implements ReportSaverService{
    Logger logger = LoggerFactory.getLogger(ReportSaverServiceToJsonImpl.class);
    @Override
    public ReportDTO saveReport(ReportDTO reportDTO) {
        logger.info("The report creation method was called" + reportDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            File file = new File("report.json");
            objectMapper.writeValue(file,reportDTO);
            String folderPath = file.getAbsolutePath();
            reportDTO.setPath(folderPath);
            logger.debug("The data has been successfully saved to a file" + reportDTO);
        } catch (IOException e){
            logger.error("Error saving JSON data" + e);
            e.getMessage();
        }
        return reportDTO;
    }


}
