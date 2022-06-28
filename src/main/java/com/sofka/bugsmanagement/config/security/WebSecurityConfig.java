package com.sofka.bugsmanagement.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.CorsRegistration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig implements WebFluxConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOrigins("**")
                .allowedMethods("GET","PUT", "DELETE")
                .allowedHeaders("**")
                .exposedHeaders("**")
                .allowCredentials(true).maxAge(3600);

        // Add more mappings...
    }




    @Bean
    SecurityWebFilterChain springWebFilter(ServerHttpSecurity http) {

        http.oauth2ResourceServer()
                .jwt();
        return http.cors().disable()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET,"/api/v1/project").authenticated()
                .pathMatchers(HttpMethod.GET,"/api/v1/bug").authenticated()
                .pathMatchers(HttpMethod.GET,"/api/v1/task").hasAnyAuthority("READER","TESTER","ADMIN")
                .pathMatchers("/api/v1/project").hasAnyAuthority("TESTER","ADMIN")
                .pathMatchers("/api/v1/bug").hasAnyAuthority("TESTER","ADMIN")
                .pathMatchers("/api/v1/task").hasAnyAuthority("TESTER","ADMIN")
                .pathMatchers("/api/v1/user").hasAnyAuthority("ADMIN")
                .anyExchange().authenticated()
                .and().build();

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
