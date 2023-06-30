package ru.skypro.lessons.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.EmployeeApplication.model.EmployeeEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmployeeFileService {
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    public void processJsonFile(MultipartFile multipartFile) {
        EmployeeEntity employee = new EmployeeEntity();
        try (JsonParser jsonParser = objectMapper.getFactory().createParser(multipartFile.getInputStream())) {
            while (jsonParser.nextToken() != null) {
                if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                    employee = objectMapper.readValue(jsonParser, EmployeeEntity.class);
                    employeeRepository.save(employee);
                }
            }
        } catch (IOException e) {
            System.out.println("Файл не найден " + e);
        }
    }
}
