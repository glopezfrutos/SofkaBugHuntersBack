package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.repositories.history.ITaskHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteTaskHistoryByIdUseCase {

    private final ITaskHistoryRepository repository;

    public Mono<Void> apply(String taskHistoryId) {
        log.info("\n***** Task History deleted. Id: {} *****\n", taskHistoryId);
        return repository.deleteById(taskHistoryId);
    }
}
