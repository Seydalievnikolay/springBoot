package ru.skypro.lessons.springboot.EmployeeApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Employee;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>,
        PagingAndSortingRepository<Employee, Integer> {

    Collection<EmployeeDTO> getEmployeesBySalaryGreaterThan(@Param("salary") double salary);

    public void deleteById(int id);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getInformationForEmployee(int id);


}
