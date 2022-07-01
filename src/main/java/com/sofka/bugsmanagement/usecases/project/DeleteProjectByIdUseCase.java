package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.collections.Project;
import com.sofka.bugsmanagement.collections.history.ProjectHistory;
import com.sofka.bugsmanagement.mappers.ProjectHistoryMapper;
import com.sofka.bugsmanagement.mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDto;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import com.sofka.bugsmanagement.repositories.history.IProjectHistoryRepository;
import com.sofka.bugsmanagement.usecases.history.CreateProjectHistoryUseCase;
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
    private final IProjectHistoryRepository projectHistoryRepository;
    private final GetTaskByProjectIdUseCase getTaskByProjectIdUseCase;
    private final DeleteTaskByIdUseCase deleteTaskByIdUseCase;
    private final ProjectHistoryMapper projectHistoryMapper;
    private final ProjectMapper projectMapper;
    private final CreateProjectHistoryUseCase createProjectHistoryUseCase;
    public Mono<Void> apply(String projectId) {
        log.info("\n***** Project deleted. Id: {} *****\n", projectId);
        return  projectRepository
                .findById(projectId)
                .flatMap(project ->{
                    Project project1=new Project(project.getId(),project.getName(),
                           project.getCreatedAt(),project.getClosedAt(),
                            project.getTeamEmails(),project.getOwners(),
                            "delete project ... "+project.getDescription(), "DELETED");
                    ProjectDto projectDto=projectMapper.convertEntityToDto().apply(project1);
                    ProjectHistory projectHistory = projectHistoryMapper.
                            convertProjectDtoToProjectHistory()
                            .apply(projectDto);

                        return projectHistoryRepository.save(projectHistory); })
                .then(
                getTaskByProjectIdUseCase
                .apply(projectId)
                .flatMap(task -> deleteTaskByIdUseCase.apply(task.getId()))
                .then(projectRepository.deleteById(projectId)));


    }
}
