package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetTaskByIdUseCase implements Function<String, Mono<TaskDTO>> {

    private final ITaskRepository repository;
    private final TaskMapper mapper;

    @Override
    public Mono<TaskDTO> apply(String id) {
        log.info("\n***** Getting tasks by Id: {} *****\n", id);
        return repository
                .findById(id)
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
