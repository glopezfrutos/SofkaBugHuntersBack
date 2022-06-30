package com.sofka.bugsmanagement.routes.user;

import com.sofka.bugsmanagement.usecases.user.DeleteUserByIdUseCase;
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
public class DeleteUserByIdRoute {
    @Bean
    RouterFunction<ServerResponse> deleteUserByIdRouter(DeleteUserByIdUseCase useCase){
        return route(DELETE("/api/v1/user/{id}")
                        .and(queryParam("confirmed", "true"))
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.NO_CONTENT)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")),Void.class)));
    }
}
