package ru.skypro.lessons.springboot.EmployeeApplication.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(AuthUser user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username) != null) return false;
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getAuthority().getUsername();
        log.info("Создан новый пользователь с именем: {}" , username);
        return true;
    }
}
