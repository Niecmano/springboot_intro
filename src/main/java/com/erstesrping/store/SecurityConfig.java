/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author darko
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/",
                        "/letovi",
                        "/register",
                        "/api/user",
                        "/images/**",
                        "/css/**",
                        "/api/gradovi/**",
                        "/api/letovi/**"
                ).permitAll()
                .requestMatchers("/letovi-auth").authenticated()
                .anyRequest().authenticated()
                )
                .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/letovi-auth", true)
                .permitAll()
                )
                .logout(logout -> logout
                .logoutSuccessUrl("/letovi")
                .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
