package com.sofka.bugsmanagement.routes.user;

import com.sofka.bugsmanagement.model.user.UserDto;
import com.sofka.bugsmanagement.usecases.user.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostUserRoute {
    //Create User
    @Bean
    public RouterFunction<ServerResponse> createUserRouter(CreateUserUseCase useCase){
        return route(
                POST("/api/v1/user").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
        );
    }
}

