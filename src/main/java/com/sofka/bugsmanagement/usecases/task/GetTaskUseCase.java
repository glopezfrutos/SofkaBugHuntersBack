package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDto;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetTaskUseCase {

    private final ITaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public Flux<TaskDto> get() {
        log.info("\n***** Getting all tasks *****\n");
        return taskRepository
                .findAll()
                .map(task -> taskMapper
                        .convertEntityToDto()
                        .apply(task));
    }

}
