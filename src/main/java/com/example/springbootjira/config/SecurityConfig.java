package com.example.springbootjira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.core.userdetails.User;
import org.springframework.core.userdetails.UserDetails;
import org.springframework.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/register", "/login", "/confirm-email").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/home", true)
            .and()
            .logout().permitAll();
        return http.build();
    }
}
