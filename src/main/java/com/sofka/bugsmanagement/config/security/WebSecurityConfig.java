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
import org.springframework.web.reactive.config.CorsRegistration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;

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
        return http
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET,"/api/v1/project").hasAnyAuthority("READER","TESTER","ADMIN","DEVELOPER")
                .pathMatchers(HttpMethod.GET,"/api/v1/bug").hasAnyAuthority("READER","TESTER","ADMIN","DEVELOPER")
                .pathMatchers(HttpMethod.GET,"/api/v1/task").hasAnyAuthority("READER","TESTER","ADMIN","DEVELOPER")
                .pathMatchers("/api/v1/project").hasAnyAuthority("TESTER","ADMIN","DEVELOPER")
                .pathMatchers("/api/v1/bug").hasAnyAuthority("TESTER","ADMIN","DEVELOPER")
                .pathMatchers("/api/v1/task").hasAnyAuthority("TESTER","ADMIN","DEVELOPER")
                .pathMatchers("/api/v1/user").permitAll()
                .and().httpBasic()
                .and().build();

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
