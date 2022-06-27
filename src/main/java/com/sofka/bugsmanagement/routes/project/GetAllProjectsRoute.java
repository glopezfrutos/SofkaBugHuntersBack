package com.sofka.bugsmanagement.routes.project;

import com.sofka.bugsmanagement.model.project.ProjectDto;
import com.sofka.bugsmanagement.usecases.project.GetProjectsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProjectsRoute {
    @Bean
    public RouterFunction<ServerResponse> getProjectsRouter(GetProjectsUseCase getProjectsUseCase){
        return route(
                GET("/api/v1/project").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getProjectsUseCase.get(), ProjectDto.class))
        );
    }
}
