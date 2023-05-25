package ru.skypro.lessons.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

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
    public List<Employee> getEmployeesSalaryAboveAverage() {
        return employeeRepository.getEmployeesSalaryAboveAverage();
    }
}
