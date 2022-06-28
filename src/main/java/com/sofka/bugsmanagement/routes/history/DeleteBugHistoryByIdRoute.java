package com.sofka.bugsmanagement.routes.history;

import com.sofka.bugsmanagement.usecases.history.DeleteBugHistoryByIdUseCase;
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
public class DeleteBugHistoryByIdRoute {
    @Bean
    RouterFunction<ServerResponse> deleteBugHistoryByIdRouter(DeleteBugHistoryByIdUseCase useCase){
        return route(DELETE("/api/v1/history/bug/{bugHistoryId}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.NO_CONTENT)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("bugHistoryId")),Void.class)));
    }
}
