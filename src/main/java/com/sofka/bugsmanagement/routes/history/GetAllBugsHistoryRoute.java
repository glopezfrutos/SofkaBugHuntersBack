package com.sofka.bugsmanagement.routes.history;

import com.sofka.bugsmanagement.model.history.BugHistoryDto;
import com.sofka.bugsmanagement.model.history.ProjectHistoryDto;
import com.sofka.bugsmanagement.usecases.history.GetBugsHistoryUseCase;
import com.sofka.bugsmanagement.usecases.history.GetProjectHistoryUseCase;
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
public class GetAllBugsHistoryRoute {
    @Bean
    public RouterFunction<ServerResponse> getBugsHistoryRouter(GetBugsHistoryUseCase useCase){
        return route(
                GET("/api/v1/history/bug").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(), BugHistoryDto.class))
        );
    }
}
