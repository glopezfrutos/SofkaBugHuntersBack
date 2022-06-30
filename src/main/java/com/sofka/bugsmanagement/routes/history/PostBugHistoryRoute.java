package com.sofka.bugsmanagement.routes.history;

import com.sofka.bugsmanagement.model.history.BugHistoryDto;
import com.sofka.bugsmanagement.usecases.history.CreateBugHistoryUseCase;
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
public class PostBugHistoryRoute {

    @Bean
    public RouterFunction<ServerResponse> createBugHistoryRouter(CreateBugHistoryUseCase useCase){
        return route(
                POST("/api/v1/history/bug").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BugHistoryDto.class).flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).bodyValue(dto)));
    }
}
