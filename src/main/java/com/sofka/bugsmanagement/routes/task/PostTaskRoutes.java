package com.sofka.bugsmanagement.routes.task;

import com.sofka.bugsmanagement.model.task.TaskDto;
import com.sofka.bugsmanagement.usecases.task.CreateTaskUseCase;
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
public class PostTaskRoutes {

    @Bean
    public RouterFunction<ServerResponse> createTaskRouter(CreateTaskUseCase createTaskUseCase) {
        return route(
                POST("/api/v1/task").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TaskDto.class)
                        .flatMap(createTaskUseCase::apply)
                        .flatMap(taskDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON).bodyValue(taskDTO))
        );
    }
}
