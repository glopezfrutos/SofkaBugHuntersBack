package com.sofka.bugsmanagement.routes.bug;

import com.sofka.bugsmanagement.usecases.bug.DeleteBugByIdUseCase;
import com.sofka.bugsmanagement.usecases.task.DeleteTaskByIdUseCase;
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
public class DeleteBugByIdRoute {
    @Bean
    RouterFunction<ServerResponse> deleteBugByIdRouter(DeleteBugByIdUseCase deleteBugByIdUseCase){
        return route(DELETE("/api/v1/bug/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.NO_CONTENT)
                        .body(BodyInserters.fromPublisher(deleteBugByIdUseCase.apply(request.pathVariable("id")),Void.class)));
    }
}
