package ru.skypro.lessons.springboot.EmployeeApplication.security;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "auth_user")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String userName;
    private String password;
    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;
}
