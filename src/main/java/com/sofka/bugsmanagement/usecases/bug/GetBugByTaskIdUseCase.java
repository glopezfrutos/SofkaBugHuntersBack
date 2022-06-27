package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetBugByTaskIdUseCase {

    private final IBugRepository repository;
    private final BugMapper mapper;

    public Flux<BugDto> apply(String taskId) {
        log.info("\n***** Getting bugs by task. TaskId: {} *****\n", taskId);
        return repository
                .findAll()
                .filter(entity -> Objects.equals(entity.getTaskId(), taskId))
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
