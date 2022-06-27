package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDto;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetTaskByIdUseCase {

    private final ITaskRepository repository;
    private final TaskMapper mapper;

    public Mono<TaskDto> apply(String id) {
        log.info("\n***** Getting task by Id: {} *****\n", id);
        return repository
                .findById(id)
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
