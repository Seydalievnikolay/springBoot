package ru.skypro.lessons.springboot.EmployeeApplication.dto;

import lombok.Builder;
import lombok.Data;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Position;

import java.util.Collection;
import java.util.List;

@Builder
@Data
public class PositionDTO {
    private String name;
    List<Position> positions;
}
