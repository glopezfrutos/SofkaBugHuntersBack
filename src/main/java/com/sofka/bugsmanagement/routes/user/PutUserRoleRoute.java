package com.sofka.bugsmanagement.routes.user;

import com.sofka.bugsmanagement.model.user.UserDto;
import com.sofka.bugsmanagement.usecases.user.UpdateUserRoleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutUserRoleRoute {
    @Bean
    public RouterFunction<ServerResponse> updateUserRoleRouter(UpdateUserRoleUseCase useCase){
        return route(
                PUT("/api/v1/user").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
        );
    }
}

