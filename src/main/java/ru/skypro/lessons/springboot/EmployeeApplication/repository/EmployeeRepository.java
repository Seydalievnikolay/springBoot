package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeRepository {
    double getSumSalary();
    Employee getMinimumSalaryEmployee();

    Employee getMaximumSalaryEmployee();

    Collection<Employee> getEmployeesSalaryAboveAverage();

    Employee createEmployee(Employee employee);
    Employee updateEmployeeById(int id, Employee employee);
    Optional<Employee> getInformationForEmployee(int id);
    Employee deleteEmployee(int id);
    Collection<Employee> getEmployeesBySalaryHigher(double salary);

    Collection<Employee> getAllEmployees();

}
