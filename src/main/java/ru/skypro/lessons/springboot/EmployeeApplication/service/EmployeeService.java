package ru.skypro.lessons.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.exception.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.EmployeeApplication.mappers.EmployeeMapper;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Position;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    public EmployeeDTO createEmployee(Employee employee) {
        Employee saveEmployee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeDto(saveEmployee);
    }

    public EmployeeDTO getInformationForEmployee(int id) {
        return employeeRepository.findById(id)
                .map(employee -> employeeMapper.toEmployeeDto(employee))
                .orElseThrow(() -> new EmployeeNotFoundException("Not found ID"));
    }

    public EmployeeDTO updateEmployeeById(int id, Employee employee) {
        EmployeeDTO findEmployee = getInformationForEmployee(id);
        Employee employeeEntity = employeeMapper.toEmployee(findEmployee);
        employeeEntity.setName(employee.getName());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setPosition(employee.getPosition());
        Employee employeeSave = employeeRepository.save(employee);
        return employeeMapper.toEmployeeDto(employeeSave);
    }

    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.getAllEmployee();
        return employeeMapper.toEmployeeDto(employees);
    }

    public void deleteById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(" Not found employee by id"));
        employeeRepository.delete(employee);
    }

    public Collection<EmployeeDTO> getEmployeesBySalaryGreaterThan(double salary) {
        return employeeRepository.getAllEmployee().stream()
                .map(employee -> employeeMapper.toEmployeeDto(employee))
                .filter(employee -> employee.getSalary() >= salary)
                .collect(Collectors.toList());

    }

    public List<EmployeeDTO> getEmployeeByPosition(Position position) {
        return employeeRepository.getAllEmployee().stream()
                .map(employee -> employeeMapper.toEmployeeDto(employee))
                .filter(employeeDTO -> employeeDTO.getPosition().equals(employeeDTO.getName()))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByPage(int number) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(number, pageSize);
        Page<Employee> employeeDTOPage = employeeRepository.findAll(pageable);
        return employeeDTOPage.stream()
                .toList();
    }
}
