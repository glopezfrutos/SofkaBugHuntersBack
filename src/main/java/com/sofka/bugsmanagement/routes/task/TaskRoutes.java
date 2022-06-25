package com.sofka.bugsmanagement.routes.task;

import com.sofka.bugsmanagement.model.TaskDTO;
import com.sofka.bugsmanagement.usecases.task.CreateTaskUseCase;
import com.sofka.bugsmanagement.usecases.task.GetTaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TaskRoutes {

    @Bean
    public RouterFunction<ServerResponse> createTaskRouter(CreateTaskUseCase createTaskUseCase) {
        return route(
                POST("/create/task").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TaskDTO.class)
                        .flatMap(createTaskUseCase::apply)
                        .flatMap(taskDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON).bodyValue(taskDTO))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getTasksRouter(GetTaskUseCase getTaskUseCase) {
        return route(
                GET("/get/tasks").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getTaskUseCase.get(),TaskDTO.class))
        );
    }
}
