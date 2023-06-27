package ru.skypro.lessons.springboot.EmployeeApplication.dto;

import lombok.*;
import ru.skypro.lessons.springboot.EmployeeApplication.model.Role;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private Role role;
    private boolean enabled;
}
