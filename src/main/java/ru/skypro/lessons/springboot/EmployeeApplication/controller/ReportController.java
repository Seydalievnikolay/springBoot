package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportToFileJsonDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.service.ReportReaderService;
import ru.skypro.lessons.springboot.EmployeeApplication.service.ReportSaverService;
import ru.skypro.lessons.springboot.EmployeeApplication.service.ReportService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private  final ReportService reportService;
    private final ReportReaderService reportReaderService;

    @PostMapping("/report")
    public int createReport() {
        return reportService.saveReportToJsonAndDB();
    }

    @GetMapping("/report/{id}")
    public ReportToFileJsonDTO getReportById(@PathVariable int id) {
        ReportDTO reportDTO = reportService.getReportById(id);
        return reportReaderService.readerReport(reportDTO);
    }
}
