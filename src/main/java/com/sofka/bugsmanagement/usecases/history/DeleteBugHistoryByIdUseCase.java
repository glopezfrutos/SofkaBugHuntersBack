package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.repositories.history.IBugHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteBugHistoryByIdUseCase {

    private final IBugHistoryRepository repository;

    public Mono<Void> apply(String bugHistoryId) {
        log.info("\n***** Bug History deleted. Id: {} *****\n", bugHistoryId);
        return repository.deleteById(bugHistoryId);
    }
}
