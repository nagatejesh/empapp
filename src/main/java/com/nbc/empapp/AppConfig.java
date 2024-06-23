package com.nbc.empapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/","/login").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/header").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                )
                .httpBasic(withDefaults())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                        .loginPage("/login")
                        .failureForwardUrl("/login?error=true")
                        .successForwardUrl("/employees")
                );
        return http.build();
    }
}
