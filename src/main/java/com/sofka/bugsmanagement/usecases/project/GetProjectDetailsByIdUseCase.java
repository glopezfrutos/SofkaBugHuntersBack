package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.mappers.ProjectDetailsMapper;
import com.sofka.bugsmanagement.model.project.ProjectDetailsDto;
import com.sofka.bugsmanagement.model.task.TaskDTO;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import com.sofka.bugsmanagement.usecases.task.GetTaskByProjectIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetProjectDetailsByIdUseCase {

    private final IProjectRepository repository;
    private final ProjectDetailsMapper projectDetailsMapper;

    private final GetTaskByProjectIdUseCase taskByProjectIdUseCase;

    public Mono<ProjectDetailsDto> apply(String id) {
        log.info("\n***** Getting project with task and bugs details. ProjectId: {} *****\n", id);
        List<TaskDTO> tasks = new ArrayList<>();
        return repository
                .findById(id)
                .map(entity -> {
                    ProjectDetailsDto dto = projectDetailsMapper.convertEntityToDto().apply(entity);
                    taskByProjectIdUseCase.apply(id).map(task -> tasks.add(task));
                    dto.setTasks(tasks);
                    return dto;
                });
    }
}
