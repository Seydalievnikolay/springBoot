package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.lessons.springboot.EmployeeApplication.handler.GlobalExceptionHandler;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lessons.springboot.EmployeeApplication.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("/salary/sum")
    public double getSalary() {
        return employeeService.getSumSalary();
    }

    @GetMapping("/salary/min")
    public Employee getMinSalary() {
        return employeeService.getMinimumSalaryEmployee();
    }

    @GetMapping("/salary/max")
    public Employee getMaxSalary() {
        return employeeService.getMaximumSalaryEmployee();
    }

    @GetMapping("/salary")
    public Collection<Employee> getEmployeeAverageSalary() {
        return employeeService.getEmployeesSalaryAboveAverage();
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
            return employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable int id,
                                       @RequestBody Employee employee) {
            return employeeService.updateEmployeeById(id, employee);
    }

    @GetMapping("/{id}")
    public Employee getInformationForEmployee(@PathVariable int id) {
        return employeeService.getInformationForEmployee(id);
    }
    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/salaryHigherThan")
    public Collection<Employee> getEmployeesBySalaryHigher(@RequestParam double salary)  {
        return employeeService.getEmployeesBySalaryHigher(salary);
    }
    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
