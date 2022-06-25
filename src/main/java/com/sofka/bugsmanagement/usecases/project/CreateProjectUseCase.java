package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.Mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CreateProjectUseCase implements Function<ProjectDTO, Mono<ProjectDTO>> {

    private final IProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public Mono<ProjectDTO> apply(ProjectDTO projectDTO) {
        return projectRepository
                .save(projectMapper.convertDtoToEntity().apply(projectDTO))
                .map(project -> projectMapper.convertEntityToDto().apply(project));
    }
}
