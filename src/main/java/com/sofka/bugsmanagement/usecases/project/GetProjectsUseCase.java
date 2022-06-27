package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDto;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;
@Service
@RequiredArgsConstructor
@Slf4j
public class GetProjectsUseCase implements Supplier<Flux<ProjectDto>> {

    private final IProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public Flux<ProjectDto> get() {
        log.info("\n***** Getting all projects *****\n");
        return projectRepository
                .findAll()
                .map(project -> projectMapper
                        .convertEntityToDto()
                        .apply(project));
    }
}
