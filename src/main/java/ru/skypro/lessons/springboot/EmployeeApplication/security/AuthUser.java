package ru.skypro.lessons.springboot.EmployeeApplication.security;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private boolean enabled;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authority_id")
    private Authority authority;
}
