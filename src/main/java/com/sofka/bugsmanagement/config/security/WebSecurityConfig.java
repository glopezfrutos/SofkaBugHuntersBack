package com.sofka.bugsmanagement.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Bean
    SecurityWebFilterChain springWebFilter(ServerHttpSecurity http) {
        final String adminRole = "ADMIN";
        final String[] allRolesExceptReader = {"TESTER", "ADMIN", "DEVELOPER"};
        final String[] allRoles = {adminRole, "READER", "TESTER", "DEVELOPER"};


        return http
                .csrf().disable()
                .authorizeExchange()
                // Every income
                .pathMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                // All roles
                .pathMatchers(HttpMethod.GET, "/api/v1/project").hasAnyAuthority(allRoles)
                .pathMatchers(HttpMethod.GET, "/api/v1/project/**").hasAnyAuthority(allRoles)
                .pathMatchers(HttpMethod.GET, "/api/v1/project-paged/**").hasAnyAuthority(allRoles)
                .pathMatchers(HttpMethod.GET, "/api/v1/bug/**").hasAnyAuthority(allRoles)
                .pathMatchers(HttpMethod.GET, "/api/v1/task/**").hasAnyAuthority(allRoles)
                .pathMatchers(HttpMethod.GET, "/api/v1/history/**").hasAnyAuthority(allRoles)
                // All roles except reader
                .pathMatchers( "/api/v1/user").hasAnyAuthority(allRolesExceptReader)
                .pathMatchers( "/api/v1/user/**").hasAnyAuthority(allRolesExceptReader)
                .pathMatchers("/api/v1/project").hasAnyAuthority(allRolesExceptReader)
                .pathMatchers("/api/v1/project/**").hasAnyAuthority(allRolesExceptReader)
                .pathMatchers("/api/v1/bug").hasAnyAuthority(allRolesExceptReader)
                .pathMatchers("/api/v1/bug/**").hasAnyAuthority(allRolesExceptReader)
                .pathMatchers("/api/v1/task").hasAnyAuthority(allRolesExceptReader)
                .pathMatchers("/api/v1/task/**").hasAnyAuthority(allRolesExceptReader)
                // Config continue
                .and().httpBasic()
                .and().build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
