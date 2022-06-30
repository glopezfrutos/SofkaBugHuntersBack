package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.repositories.IProjectRepository;
import com.sofka.bugsmanagement.usecases.task.DeleteTaskByIdUseCase;
import com.sofka.bugsmanagement.usecases.task.GetTaskByProjectIdUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteProjectByIdUseCase {
    private final IProjectRepository projectRepository;
    private final GetTaskByProjectIdUseCase getTaskByProjectIdUseCase;
    private final DeleteTaskByIdUseCase deleteTaskByIdUseCase;

    public Mono<Void> apply(String projectId) {
        log.info("\n***** Project deleted. Id: {} *****\n", projectId);
        return getTaskByProjectIdUseCase
                .apply(projectId)
                .flatMap(task -> deleteTaskByIdUseCase.apply(task.getId()))
                .then(projectRepository.deleteById(projectId));
    }
}
