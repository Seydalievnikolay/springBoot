package ru.skypro.lessons.springboot.EmployeeApplication.mappers;

import org.mapstruct.Mapper;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;

@Mapper
public interface ReportMapper {
    ReportDTO toReportDto(ReportEntity reportEntity);
    ReportEntity toEntity(ReportDTO reportDTO);
}
