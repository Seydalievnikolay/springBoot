package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    double getSumSalary();
    Employee getMinimumSalaryEmployee();

    Employee getMaximumSalaryEmployee();

    List<Employee> getEmployeesSalaryAboveAverage();
}
