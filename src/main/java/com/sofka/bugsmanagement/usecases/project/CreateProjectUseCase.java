package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.Mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
public class CreateProjectUseCase {

    private final IProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public Mono<ProjectDTO> apply(@Valid ProjectDTO projectDTO) {
        return projectRepository
                .save(projectMapper.convertDtoToEntity().apply(projectDTO))
                .map(project -> projectMapper.convertEntityToDto().apply(project));
    }
}
