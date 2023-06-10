package ru.skypro.lessons.springboot.EmployeeApplication.model;

import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private double salary;
}
