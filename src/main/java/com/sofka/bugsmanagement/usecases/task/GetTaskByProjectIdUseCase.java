package com.sofka.bugsmanagement.usecases.task;

import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetTaskByProjectIdUseCase {

    private final ITaskRepository repository;
    private final TaskMapper mapper;

    public Flux<TaskDTO> apply(String projectId) {
        return repository
                .findAll()
                .filter(entity -> Objects.equals(entity.getProjectId(), projectId))
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
