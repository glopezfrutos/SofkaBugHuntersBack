package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
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

    public Mono<ProjectDTO> apply(@Valid ProjectDTO projectDTO) {
        log.info("*** New Project created *** Id: {}", projectDTO.getId());
        return projectRepository
                .save(projectMapper.convertDtoToEntity().apply(projectDTO))
                .map(project -> projectMapper
                        .convertEntityToDto()
                        .apply(project));
    }
}
