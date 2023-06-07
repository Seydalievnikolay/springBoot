package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import org.springframework.stereotype.Component;
import ru.skypro.lessons.springboot.EmployeeApplication.exception.BadRequestException;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private int countId = 1;

    private final Map<Integer,Employee> employeeMap = new HashMap<>();

    public EmployeeRepositoryImpl() {
        createEmployee(new Employee(0, "Alexey", 65000));
        createEmployee(new Employee(0, "Maxim", 32700));
        createEmployee(new Employee(0, "Ivan", 32700));
        createEmployee(new Employee(0, "Vyacheslav", 53400));
        createEmployee(new Employee(0, "Ilya", 94250));
        createEmployee(new Employee(0, "Pavel", 120000));
    }


    @Override
    public double getSumSalary() {
        return employeeMap.values().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getMinimumSalaryEmployee() {
        return employeeMap.values().stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new BadRequestException("Некорректное значение"));
    }

    @Override
    public Employee getMaximumSalaryEmployee() {
        return employeeMap.values().stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new BadRequestException("Некорректное значение"));
    }

    @Override
    public Collection<Employee> getEmployeesSalaryAboveAverage() {
         double avg = employeeMap.values().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                 .orElseThrow(() -> new BadRequestException("Нет данных"));
         return employeeMap.values().stream()
                 .filter(employee -> employee.getSalary() > avg)
                 .collect(Collectors.toList());
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee builder = Employee.builder()
                .id(countId++)
                .name(employee.getName())
                .salary(employee.getSalary())
                .build();
        return employeeMap.put(builder.getId(), builder);
    }

    @Override
    public Employee updateEmployeeById(int id, Employee employee) {
        Employee findEmployee = getInformationForEmployee(id)
                .orElseThrow(() -> new BadRequestException("Введены некорректные данные"));

        return employeeMap.computeIfPresent(id, (nextId, oldEmployee)->
                new Employee(oldEmployee.getId(), employee.getName(), employee.getSalary()));
    }

    @Override
    public Optional<Employee> getInformationForEmployee(int id) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getId()==id)
                .findFirst();
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee findEmployee = getInformationForEmployee(id)
                .orElseThrow(() -> new BadRequestException("Введены некорректные данные"));
        Employee deleteEmployee = employeeMap.values().stream()
                .filter(employee -> employee.getId() == findEmployee.getId())
                .findFirst()
                .get();
        return employeeMap.remove(deleteEmployee.getId());
    }

    @Override
    public Collection<Employee> getEmployeesBySalaryHigher(double salary) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getSalary() >= salary)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }
}
