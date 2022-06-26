package com.sofka.bugsmanagement.usecases.project;

import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProjectByIdUseCase {
    private final IProjectRepository projectRepository;

    public Mono<Void> apply(String id){
        return projectRepository.deleteById(id);
    }
}
