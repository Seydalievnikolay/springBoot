package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;

@Service
@Slf4j
public class ReportSaverServiceToJsonImpl implements ReportSaverService{
    @Override
    public ReportEntity saveReport(ReportEntity reportEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            File file = new File("report.json");
            objectMapper.writeValue(file,reportEntity);
            String folderPath = file.getAbsolutePath();
            reportEntity.setFilePath(folderPath);
            log.info("Данные успешно сохранены в файл");
        } catch (IOException e){
            log.info("Ошибка при сохранениии данных JSON" + e.getMessage());
        }
        return reportEntity;
    }


}
