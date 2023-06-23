package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/employees")
public class AdminEmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
