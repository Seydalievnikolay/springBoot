package ru.skypro.lessons.springboot.EmployeeApplication.mappers;

import org.mapstruct.Mapper;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.UserDTO;
import ru.skypro.lessons.springboot.EmployeeApplication.security.AuthUser;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto (AuthUser authUser);
    AuthUser toUser (UserDTO userDTO);
}
