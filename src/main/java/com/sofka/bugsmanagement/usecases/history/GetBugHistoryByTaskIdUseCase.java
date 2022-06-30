package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.mappers.BugHistoryMapper;
import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.model.history.BugHistoryDto;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import com.sofka.bugsmanagement.repositories.history.IBugHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetBugHistoryByTaskIdUseCase {

    private final IBugHistoryRepository repository;
    private final BugHistoryMapper mapper;

    public Flux<BugHistoryDto> apply(String taskId) {
        log.info("\n***** Getting bugs history by task. TaskId: {} *****\n", taskId);
        return repository
                .findAll()
                .filter(entity -> Objects.equals(entity.getTaskId(), taskId))
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
