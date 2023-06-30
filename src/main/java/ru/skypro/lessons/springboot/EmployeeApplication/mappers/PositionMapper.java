package ru.skypro.lessons.springboot.EmployeeApplication.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.PositionDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.PositionEntity;
@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);
    PositionDTO toPositionDTO(PositionEntity position);
}
