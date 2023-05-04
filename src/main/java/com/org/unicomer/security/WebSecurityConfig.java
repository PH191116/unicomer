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
            http.requiresChannel((channel) -> channel.anyRequest()
                    .requiresInsecure().requestMatchers("/**"));/*authorizeHttpRequests()
// Las vistas públicas no requieren autenticación
                    .requestMatchers("/**").permitAll()
// El formulario de Login no requiere autenticacion
                    .and().formLogin().permitAll()*/

            return http.build();
        }

}
