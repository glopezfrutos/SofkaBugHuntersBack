package com.sofka.bugsmanagement.routes.task;

import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.usecases.project.GetProjectByIdUseCase;
import com.sofka.bugsmanagement.usecases.task.GetTaskByIdUseCase;
import com.sofka.bugsmanagement.usecases.task.GetTaskUseCase;
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
public class GetTaskByIdRoute {
    @Bean
    public RouterFunction<ServerResponse> getTaskByIdRouter(GetTaskByIdUseCase useCase){
        return route(
                GET("/api/v1/task/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")), TaskDTO.class))
        );
    }
}
