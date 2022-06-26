package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.mappers.ProjectDetailsMapper;
import com.sofka.bugsmanagement.mappers.TaskMapper;
import com.sofka.bugsmanagement.model.project.ProjectDetailsDto;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import com.sofka.bugsmanagement.usecases.task.GetTaskByProjectIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetProjectDetailsByIdUseCase {

    private final IProjectRepository repository;
    private final ProjectDetailsMapper projectDetailsMapper;

    private final TaskMapper taskMapper;

    private final GetTaskByProjectIdUseCase taskByProjectIdUseCase;

    public Mono<ProjectDetailsDto> apply(String id) {
        List<TaskDTO> tasks = new ArrayList<>();
        return repository
                .findById(id)
                .publishOn(Schedulers.boundedElastic())
                .map(entity -> {
                    ProjectDetailsDto dto = projectDetailsMapper.convertEntityToDto().apply(entity);
                    taskByProjectIdUseCase.apply(id).map(tasks::add);
                    dto.setTasks(tasks);
                    return dto;
                });
    }
}
