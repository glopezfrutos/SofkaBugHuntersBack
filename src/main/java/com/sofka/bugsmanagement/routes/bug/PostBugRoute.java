package com.sofka.bugsmanagement.routes.bug;

import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.usecases.bug.CreateBugUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostBugRoute {
    @Bean
    public RouterFunction<ServerResponse> createBugRouter(CreateBugUseCase useCase){
        return route(
                POST("/api/v1/bug").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BugDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
        );
    }
}
