package com.sofka.bugsmanagement.routes.project;

import com.sofka.bugsmanagement.usecases.bug.DeleteBugByIdUseCase;
import com.sofka.bugsmanagement.usecases.project.DeleteProjectHistoryByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProjectHistoryByIdRoute {

    @Bean
    RouterFunction<ServerResponse> deleteProjectHistoryByIdRouter(DeleteProjectHistoryByIdUseCase useCase){
        return route(DELETE("/api/v1/history-project/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.NO_CONTENT)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("projectHistoryId")),Void.class)));
    }

}
