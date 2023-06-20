package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.ReportEntity;

import java.util.List;
@Repository
public interface ReportRepository extends CrudRepository<ReportEntity, Integer> {

}
