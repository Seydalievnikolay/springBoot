package ru.skypro.lessons.springboot.EmployeeApplication.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.skypro.lessons.springboot.EmployeeApplication.dto.UserDTO;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AppUserDetails implements UserDetails {

    private UserDTO userDetails;

    public void setUserDetails(UserDTO userDetails) {
        this.userDetails = userDetails;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Optional.ofNullable(userDetails)
                .filter(UserDTO::isEnabled)
                .map(UserDTO::getRole)
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .map(List::of)
                .orElse(Collections.emptyList());
    }

    @Override
    public String getPassword() {
        return Optional.ofNullable(userDetails)
                .map(UserDTO::getPassword)
                .orElse(null);
    }

    @Override
    public String getUsername() {
        return Optional.ofNullable(userDetails)
                .map(UserDTO::getLogin)
                .orElse(null);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Optional.ofNullable(userDetails)
                .map(UserDTO::isEnabled)
                .orElse(false);
    }
}
