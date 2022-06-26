package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetTaskByProjectIdUseCase {

    private final ITaskRepository repository;
    private final TaskMapper mapper;

    public Flux<TaskDTO> apply(String projectId) {
        log.info("\n***** Getting tasks by project. ProjectId: {} *****\n", projectId);
        return repository
                .findAll()
                .filter(entity -> Objects.equals(entity.getProjectId(), projectId))
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
