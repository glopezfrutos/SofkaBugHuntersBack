package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteTaskByIdUseCase {
    private final ITaskRepository taskRepository;

    public Mono<Void> apply(String id){
        // TODO: Delete all bugs related to this project
        log.info("\n***** Task deleted. Id: {} *****\n", id);
        return taskRepository.deleteById(id);
    }
}
