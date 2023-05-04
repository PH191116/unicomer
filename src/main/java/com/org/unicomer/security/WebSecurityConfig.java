package com.org.unicomer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests()
// Las vistas públicas no requieren autenticación
                    .requestMatchers("/api/**").permitAll()
// Todas las demás URLs de la Aplicación requieren autenticación
                    //.anyRequest().authenticated()
// El formulario de Login no requiere autenticacion
                    .and().formLogin().disable();
            return http.build();
        }

}
