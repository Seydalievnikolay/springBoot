package ru.skypro.lessons.springboot.EmployeeApplication.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.EmployeeApplication.mappers.UserMapper;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final AppUserDetails appUserDetails;

    public UserService(UserRepository userRepository, UserMapper mapper, AppUserDetails appUserDetails) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.appUserDetails = appUserDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        appUserDetails.setUserDetails(mapper.toDto(appUser));
        return appUserDetails;
    }
}
