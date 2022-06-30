package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.mappers.ProjectHistoryMapper;
import com.sofka.bugsmanagement.mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDto;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import com.sofka.bugsmanagement.repositories.history.IProjectHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class CreateProjectUseCase {

    private final IProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    private final IProjectHistoryRepository projectHistoryRepository;
    private final ProjectHistoryMapper projectHistoryMapper;

    public Mono<ProjectDto> apply(@Valid ProjectDto projectDTO) {
        log.info("\n***** New Project created. Id: {} *****\n", projectDTO.getId());
        return projectHistoryRepository
                .save(projectHistoryMapper
                        .convertProjectDtoToProjectHistory()
                        .apply(projectDTO))
                .then(projectRepository
                .save(projectMapper.convertDtoToEntity().apply(projectDTO))
                .map(project -> projectMapper
                        .convertEntityToDto()
                        .apply(project)));
    }
}
