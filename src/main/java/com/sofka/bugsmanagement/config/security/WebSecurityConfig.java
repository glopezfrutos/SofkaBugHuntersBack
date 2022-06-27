package com.sofka.bugsmanagement.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    SecurityWebFilterChain springWebFilter(ServerHttpSecurity http) {

        http.oauth2ResourceServer()
                .jwt();
        return http.csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET,"/api/v1/project").permitAll()
                .anyExchange().authenticated()
                .and().build();

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
