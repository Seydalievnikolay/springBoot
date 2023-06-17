package ru.skypro.lessons.springboot.EmployeeApplication.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Accessors(chain = true)
@Table(name = "report")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "number_of_employees")
    private int numberOfEmployees;
    @Column(name = "max_salary")
    private double maxSalary;
    @Column(name = "min_salary")
    private double minSalary;
    @Column(name = "average_salary")
    private double averageSalary;

}
