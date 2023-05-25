package ru.skypro.lessons.springboot.EmployeeApplication.service;

import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeService {
    double getSumSalary();
    Employee getMinimumSalaryEmployee();

    Employee getMaximumSalaryEmployee();

    List<Employee> getEmployeesSalaryAboveAverage();
}
