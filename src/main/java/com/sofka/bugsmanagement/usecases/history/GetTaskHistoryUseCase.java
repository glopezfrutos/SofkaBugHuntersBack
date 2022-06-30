package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.mappers.BugHistoryMapper;
import com.sofka.bugsmanagement.mappers.TaskHistoryMapper;
import com.sofka.bugsmanagement.model.history.BugHistoryDto;
import com.sofka.bugsmanagement.model.history.TaskHistoryDto;
import com.sofka.bugsmanagement.repositories.history.IBugHistoryRepository;
import com.sofka.bugsmanagement.repositories.history.ITaskHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
@Service
@RequiredArgsConstructor
@Slf4j
public class GetTaskHistoryUseCase {
    private final ITaskHistoryRepository repository;
    private final TaskHistoryMapper mapper;

    public Flux<TaskHistoryDto> apply() {
        log.info("\n***** Getting All History Project *****\n");
        return repository
                .findAll()
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
