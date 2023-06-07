package ru.skypro.lessons.springboot.EmployeeApplication.service;

import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    double getSumSalary();
    Employee getMinimumSalaryEmployee();

    Employee getMaximumSalaryEmployee();

    Collection<Employee> getEmployeesSalaryAboveAverage();
    Employee createEmployee(Employee employee);
    Employee updateEmployeeById(int id, Employee employee);
    Employee getInformationForEmployee(int id);
    Employee deleteEmployee(int id);
    Collection<Employee> getEmployeesBySalaryHigher(double salary);
    Collection<Employee> getAllEmployees();
}
