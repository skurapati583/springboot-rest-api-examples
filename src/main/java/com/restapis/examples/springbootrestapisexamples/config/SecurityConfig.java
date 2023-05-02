package com.restapis.examples.springbootrestapisexamples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/toys").hasRole("ADMIN")
                .anyRequest().authenticated();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails regular = User.withUsername("regular_user")
                .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
                .roles("REGULAR")
                .build();

        UserDetails admin = User.withUsername("admin_user")
                .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(regular, admin);
    }

}
