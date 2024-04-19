package br.com.alura.api.security;

import br.com.alura.api.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/users").hasAnyRole(Role.STUDENT.name(),
                        Role.INSTRUCTOR.name(), Role.ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/users").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/courses").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.PUT, "/courses").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/courses").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/registrations").hasAnyRole(Role.ADMIN.name(),
                        Role.STUDENT.name(), Role.INSTRUCTOR.name())
                .anyRequest().authenticated()).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
