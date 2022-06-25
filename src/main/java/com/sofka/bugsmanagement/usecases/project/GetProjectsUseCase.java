package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.Mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;
@Service
@RequiredArgsConstructor
public class GetProjectsUseCase implements Supplier<Flux<ProjectDTO>> {

    private final IProjectRepository projectRepository;
    private final ProjectMapper projectMapper;


    @Override
    public Flux<ProjectDTO> get() {
        return projectRepository
                .findAll()
                .map(project -> projectMapper
                        .convertEntityToDto()
                        .apply(project));
    }
}
