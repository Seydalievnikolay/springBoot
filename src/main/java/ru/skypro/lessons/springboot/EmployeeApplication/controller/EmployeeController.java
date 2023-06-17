package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.EmployeeEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.model.PositionEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.service.EmployeeFileService;
import ru.skypro.lessons.springboot.EmployeeApplication.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeFileService employeeFileService;

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeEntity employee) {
            return employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployeeById(@PathVariable int id,
                                       @RequestBody EmployeeEntity employee) {
            return employeeService.updateEmployeeById(id, employee);
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeDTO getInformationForEmployee(@PathVariable int id) {
        return employeeService.getInformationForEmployee(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/salaryHigherThan")
    public Collection<EmployeeDTO> getEmployeesBySalaryGreaterThan(@RequestParam double salary)  {
        return employeeService.getEmployeesBySalaryGreaterThan(salary);
    }
    @GetMapping
    public Collection<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/position")
    public List<EmployeeDTO> getEmployeeByPosition(PositionEntity position) {
        return employeeService.getEmployeeByPosition(position);
    }
    @GetMapping("/page")
    public List<EmployeeEntity> getEmployeesByPage(int number) {
        return employeeService.getEmployeesByPage(number);
    }
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void processJsonFile(@RequestParam("file") MultipartFile file) {
         employeeFileService.processJsonFile(file);
    }

    public void re
}
