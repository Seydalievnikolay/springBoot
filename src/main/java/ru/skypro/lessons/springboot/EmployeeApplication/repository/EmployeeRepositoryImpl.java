package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import org.springframework.stereotype.Component;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private static final List<Employee> EMPLOYEES = List.of(
            new Employee("Alexey", 65000),
            new Employee("Maxim", 32700),
            new Employee("Ivan", 32700),
            new Employee("Vyacheslav", 53400),
            new Employee("Ilya", 94250),
            new Employee("Pavel", 120000)


    );

    @Override
    public double getSumSalary() {
        return EMPLOYEES.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

    }

    @Override
    public Employee getMinimumSalaryEmployee() {
        return EMPLOYEES.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();

    }

    @Override
    public Employee getMaximumSalaryEmployee() {
        return EMPLOYEES.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getEmployeesSalaryAboveAverage() {
         double avg = EMPLOYEES.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                 .orElseThrow(() -> new IllegalArgumentException("Нет данных"));
         return EMPLOYEES.stream()
                 .filter(employee -> employee.getSalary() > avg)
                 .collect(Collectors.toList());
    }
}
