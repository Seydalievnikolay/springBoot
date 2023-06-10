package ru.skypro.lessons.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.exception.BadRequestException;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public double getSumSalary() {
        return employeeRepository.getSumSalary();
    }

    @Override
    public Employee getMinimumSalaryEmployee() {
        return employeeRepository.getMinimumSalaryEmployee();
    }

    @Override
    public Employee getMaximumSalaryEmployee() {
        return employeeRepository.getMaximumSalaryEmployee();
    }

    @Override
    public Collection<Employee> getEmployeesSalaryAboveAverage() {
        return employeeRepository.getEmployeesSalaryAboveAverage();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee updateEmployeeById(int id, Employee employee) {
        return employeeRepository.updateEmployeeById(id, employee);
    }

    @Override
    public Employee getInformationForEmployee(int id) {
        return employeeRepository.getInformationForEmployee(id)
                .orElseThrow(() -> new BadRequestException("Введены некорректные данные"));
    }

    @Override
    public Employee deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public Collection<Employee> getEmployeesBySalaryHigher(double salary) {
        return employeeRepository.getEmployeesBySalaryHigher( salary);
    }


    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
