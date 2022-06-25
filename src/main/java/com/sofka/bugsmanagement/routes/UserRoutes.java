package com.sofka.bugsmanagement.routes;

import com.sofka.bugsmanagement.model.UserDto;
import com.sofka.bugsmanagement.usecases.project.CreateUserUseCase;
import com.sofka.bugsmanagement.usecases.project.GetUsersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRoutes {
    //Create User
    @Bean
    public RouterFunction<ServerResponse> createUserRouter(CreateUserUseCase useCase){
        return route(
                POST("/user").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
        );
    }

    // Get Users
    @Bean
    public RouterFunction<ServerResponse> getUsersRouter(GetUsersUseCase useCase){
        return route(
                GET("/user").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), UserDto.class))
        );
    }
}
