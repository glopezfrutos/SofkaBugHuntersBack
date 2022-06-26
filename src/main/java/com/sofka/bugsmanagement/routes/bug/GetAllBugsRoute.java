package com.sofka.bugsmanagement.routes.bug;

import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.usecases.bug.GetBugsUseCase;
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
public class GetAllBugsRoute {
    @Bean
    public RouterFunction<ServerResponse> getBugsRouter(GetBugsUseCase useCase) {
        return route(
                GET("/api/v1/bug").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), BugDto.class))
        );
    }
}
