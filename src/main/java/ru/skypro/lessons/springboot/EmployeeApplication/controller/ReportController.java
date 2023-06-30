package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportToFileJsonDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.ReportRepository;
import ru.skypro.lessons.springboot.EmployeeApplication.service.ReportReaderService;
import ru.skypro.lessons.springboot.EmployeeApplication.service.ReportSaverService;
import ru.skypro.lessons.springboot.EmployeeApplication.service.ReportService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private  final ReportService reportService;
    private final ReportReaderService reportReaderService;
    private final ReportRepository reportRepository;

    @PostMapping("/report")
    public int createReport() {
        return reportService.saveReportToJsonAndDB();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getReportById(@PathVariable int id) {
        String file = "file.json";
        String jsonFile = reportService.getReportById(id).getFilePath();
        Resource resource = new ByteArrayResource(jsonFile.getBytes());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}
