package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Position;
import ru.skypro.lessons.springboot.EmployeeApplication.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody Employee employee) {
            return employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployeeById(@PathVariable int id,
                                       @RequestBody Employee employee) {
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
    public List<EmployeeDTO> getEmployeeByPosition(Position position) {
        return employeeService.getEmployeeByPosition(position);
    }
    @GetMapping("/page")
    public List<Employee> getEmployeesByPage(int number) {
        return employeeService.getEmployeesByPage(number);
    }
}
