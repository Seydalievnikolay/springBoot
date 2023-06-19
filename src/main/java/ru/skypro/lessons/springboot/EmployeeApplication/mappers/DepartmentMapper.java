package ru.skypro.lessons.springboot.EmployeeApplication.mappers;

import org.mapstruct.Mapper;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.DepartmentDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.DepartmentEntity;
@Mapper
public interface DepartmentMapper {
    DepartmentDTO toDepDto (DepartmentEntity department);
    DepartmentEntity toDepEntity (DepartmentDTO depDto);
}
