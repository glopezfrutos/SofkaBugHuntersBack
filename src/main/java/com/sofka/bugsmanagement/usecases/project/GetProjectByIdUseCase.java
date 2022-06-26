package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetProjectByIdUseCase implements Function<String, Mono<ProjectDTO>> {

    private final IProjectRepository repository;
    private final ProjectMapper mapper;

    @Override
    public Mono<ProjectDTO> apply(String id) {
        log.info("\n***** Getting project by Id: {} *****\n", id);
        return repository
                .findById(id)
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
