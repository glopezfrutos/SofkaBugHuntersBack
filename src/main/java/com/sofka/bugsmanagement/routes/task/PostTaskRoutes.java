package com.sofka.bugsmanagement.routes.task;

import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.usecases.task.CreateTaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostTaskRoutes {

    @Bean
    public RouterFunction<ServerResponse> createTaskRouter(CreateTaskUseCase createTaskUseCase) {
        return route(
                POST("/api/v1/task").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TaskDTO.class)
                        .flatMap(createTaskUseCase::apply)
                        .flatMap(taskDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON).bodyValue(taskDTO))
        );
    }
}
