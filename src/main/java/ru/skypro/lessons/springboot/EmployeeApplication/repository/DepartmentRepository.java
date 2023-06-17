package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.EmployeeApplication.model.DepartmentEntity;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Integer> {
    @Override
    List<DepartmentEntity> findAll();
}
