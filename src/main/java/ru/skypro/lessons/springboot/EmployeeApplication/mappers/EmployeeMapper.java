package ru.skypro.lessons.springboot.EmployeeApplication.mappers;

import org.mapstruct.Mapper;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.EmployeeEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDto(EmployeeEntity employee);
    EmployeeEntity toEntity(EmployeeDTO dto);
    List<EmployeeDTO> toDto(List<EmployeeEntity> employees);
    List<EmployeeEntity> toEntity(List<EmployeeDTO> dtos);
}
