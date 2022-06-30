package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.mappers.ProjectHistoryMapper;
import com.sofka.bugsmanagement.model.history.ProjectHistoryDto;
import com.sofka.bugsmanagement.repositories.history.IProjectHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetProjectHistoryUseCase {
    private final IProjectHistoryRepository repository;
    private final ProjectHistoryMapper mapper;

    public Flux<ProjectHistoryDto> apply() {
        log.info("\n***** Getting All History Project *****\n");
        return repository
                .findAll()
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}

