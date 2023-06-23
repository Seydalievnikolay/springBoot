package ru.skypro.lessons.springboot.EmployeeApplication.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<AuthUser,Long> {
    @Query("SELECT e.username from AuthUser e where e.username =: username")
    AuthUser findByUsername(String username);
}
