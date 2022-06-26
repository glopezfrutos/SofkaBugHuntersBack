package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteTaskByIdUseCase {
    private final ITaskRepository taskRepository;

    public Mono<Void> apply(String id){
        return taskRepository.deleteById(id);
    }
}
