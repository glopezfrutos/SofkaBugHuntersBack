package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.mappers.BugHistoryMapper;
import com.sofka.bugsmanagement.mappers.ProjectHistoryMapper;
import com.sofka.bugsmanagement.model.history.BugHistoryDto;
import com.sofka.bugsmanagement.model.history.ProjectHistoryDto;
import com.sofka.bugsmanagement.repositories.history.IBugHistoryRepository;
import com.sofka.bugsmanagement.repositories.history.IProjectHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetBugsHistoryUseCase {
    private final IBugHistoryRepository repository;
    private final BugHistoryMapper mapper;

    public Flux<BugHistoryDto> apply() {
        log.info("\n***** Getting All Bug History  *****\n");
        return repository
                .findAll()
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}
