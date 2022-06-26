package com.sofka.bugsmanagement.routes.project;

import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.usecases.project.CreateProjectUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@Validated
public class PostProjectRoute {
    //Create Project
    @Bean
    public RouterFunction<ServerResponse> createProjectRouter(CreateProjectUseCase createProjectUseCase){
        return route(
                POST("/api/v1/project").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProjectDTO.class)
                        .flatMap(createProjectUseCase::apply)
                        .flatMap(projectDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(projectDTO))
        );
    }


}
