package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lessons.springboot.EmployeeApplication.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("salary/sum")
    public double getSalary() {
        return employeeService.getSumSalary();
    }

    @GetMapping("salary/min")
    public Employee getMinSalary() {
        return employeeService.getMinimumSalaryEmployee();
    }

    @GetMapping("salary/max")
    public Employee getMaxSalary() {
        return employeeService.getMaximumSalaryEmployee();
    }

    @GetMapping("salary")
    public List<Employee> getEmployeeAverageSalary() {
        return employeeService.getEmployeesSalaryAboveAverage();
    }
}
