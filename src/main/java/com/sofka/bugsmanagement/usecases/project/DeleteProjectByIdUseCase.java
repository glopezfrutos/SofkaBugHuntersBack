package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteProjectByIdUseCase {
    private final IProjectRepository projectRepository;

    public Mono<Void> apply(String id){
        // TODO: Delete all tasks related to this project
        log.info("\n***** Project deleted. Id: {} *****\n", id);
        return projectRepository.deleteById(id);
    }
}
