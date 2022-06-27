package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetBugByIdUseCase {

    private final IBugRepository repository;
    private final BugMapper mapper;

    public Mono<BugDto> apply(String id) {
        log.info("\n***** Getting Bug by Id: {} *****\n", id);
        return repository
                .findById(id)
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
