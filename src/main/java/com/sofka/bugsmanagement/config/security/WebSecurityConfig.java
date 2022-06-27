package com.sofka.bugsmanagement.config.security;

import org.springframework.context.annotation.Bean;

//@Configuration
//@EnableWebFluxSecurity
public class WebSecurityConfig {
/*
    @Bean
    SecurityWebFilterChain springWebFilter(ServerHttpSecurity http) {

        http.oauth2ResourceServer()
                .jwt();
        return http.csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET,"/").permitAll()
                .pathMatchers("webjars/swagger-ui/index.html#/").permitAll()

                .pathMatchers(HttpMethod.GET,"/login").permitAll()
                .pathMatchers("/create").permitAll()
                .pathMatchers("/route-no-auth").permitAll()
                .pathMatchers(HttpMethod.GET, "/no-auth").permitAll()
                .pathMatchers(HttpMethod.GET,"/role-admin").hasAuthority("ADMIN")
                .pathMatchers(HttpMethod.GET,"/role-admincito").hasAuthority("ADMIN")
                .pathMatchers(HttpMethod.GET,"/route-auth").hasAuthority("ADMIN")
                .pathMatchers(HttpMethod.GET,"/role-creator").hasAuthority("CREATOR")
                .anyExchange().permitAll()
                .and()
                .formLogin()
                .and().build();

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

 */
}
