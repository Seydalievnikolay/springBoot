package ru.skypro.lessons.springboot.EmployeeApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {


        UserDetails ivan = User.withUsername("Ivan")
                .password(passwordEncoder.encode("ivan1234"))
                .roles("USER")
                .build();


        UserDetails vladimir = User.withUsername("Vladimir")
                .password(passwordEncoder.encode("vladimir1234"))
                .roles("USER")
                .build();


        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin1234"))
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ivan, vladimir, admin);
    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource,
                                                 AuthenticationManager authenticationManager) {
        JdbcUserDetailsManager jdbcUserDetailsManager =
                new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
        return jdbcUserDetailsManager;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/*"))
                .authorizeHttpRequests(this::customizeRequest)
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());
        return http.build();
    }

    private void customizeRequest(
            AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
        try {
            registry.requestMatchers(HttpMethod.GET,"/employee/**").hasAnyRole("USER","ADMIN")
                    .requestMatchers(HttpMethod.POST,"/employee/**").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT,"/employee/**").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE,"/employee/**").hasAnyRole("ADMIN");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}