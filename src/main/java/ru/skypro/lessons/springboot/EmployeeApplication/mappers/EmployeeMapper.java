package ru.skypro.lessons.springboot.EmployeeApplication.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toEmployeeDto(Employee employee);
    Employee toEmployee (EmployeeDTO dto);
    List<EmployeeDTO> toEmployeeDto (List<Employee> employees);
    List<Employee> toEmployee(List<EmployeeDTO> dtos);
}
