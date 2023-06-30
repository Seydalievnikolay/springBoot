package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.EmployeeApplication.model.EmployeeEntity;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer>,
        PagingAndSortingRepository<EmployeeEntity, Integer> {
    @Override
    Collection<EmployeeEntity> findAll();
}
