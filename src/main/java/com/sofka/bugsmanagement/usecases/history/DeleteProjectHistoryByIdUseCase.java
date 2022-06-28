package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.repositories.history.IProjectHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteProjectHistoryByIdUseCase {

    private final IProjectHistoryRepository repository;

    public Mono<Void>  apply(String projectHistoryId) {
        log.info("\n***** Project History deleted. Id: {} *****\n", projectHistoryId);
        return repository.deleteById(projectHistoryId);
    }
}
