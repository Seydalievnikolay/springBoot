package ru.skypro.lessons.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.exception.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.EmployeeApplication.mappers.EmployeeMapper;
import ru.skypro.lessons.springboot.EmployeeApplication.model.EmployeeEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.model.PositionEntity;
import ru.skypro.lessons.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO createEmployee(EmployeeEntity employee) {
        EmployeeEntity saveEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(saveEmployee);
    }

    public EmployeeDTO getInformationForEmployee(int id) {
        return employeeRepository.findById(id)
                .map(employee -> employeeMapper.toDto(employee))
                .orElseThrow(() -> new EmployeeNotFoundException("Not found ID"));
    }

    public EmployeeDTO updateEmployeeById(int id, EmployeeEntity employee) {
        EmployeeDTO findEmployee = getInformationForEmployee(id);
        EmployeeEntity employeeEntity = employeeMapper.toEntity(findEmployee);
        employeeEntity.setName(employee.getName());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setPosition(employee.getPosition());
        EmployeeEntity employeeSave = employeeRepository.save(employee);
        return employeeMapper.toDto(employeeSave);
    }

    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(employee -> employeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }

    public void deleteById(int id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(" Not found employee by id"));
        employeeRepository.delete(employee);
    }

    public Collection<EmployeeDTO> getEmployeesBySalaryGreaterThan(double salary) {
        return employeeRepository.findAll().stream()
                .map(employee -> employeeMapper.toDto(employee))
                .filter(employee -> employee.getSalary() >= salary)
                .collect(Collectors.toList());

    }

    public List<EmployeeDTO> getEmployeeByPosition(PositionEntity position) {
        return employeeRepository.findAll().stream()
                .map(employee -> employeeMapper.toDto(employee))
                .filter(employeeDTO -> employeeDTO.getPosition().equals(employeeDTO.getName()))
                .collect(Collectors.toList());
    }

    public List<EmployeeEntity> getEmployeesByPage(int number) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(number, pageSize);
        Page<EmployeeEntity> employeeDTOPage = employeeRepository.findAll(pageable);
        return employeeDTOPage.stream()
                .toList();
    }

}
