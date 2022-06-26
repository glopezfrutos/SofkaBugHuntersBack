package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.mappers.ProjectMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.model.project.ProjectDTO;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import com.sofka.bugsmanagement.repositories.IProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GetBugByIdUseCase implements Function<String, Mono<BugDto>> {

    private final IBugRepository repository;
    private final BugMapper mapper;

    @Override
    public Mono<BugDto> apply(String id) {
        return repository
                .findById(id)
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
