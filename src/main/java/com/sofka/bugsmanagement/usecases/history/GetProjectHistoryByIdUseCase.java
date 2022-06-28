package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.mappers.ProjectHistoryMapper;
import com.sofka.bugsmanagement.model.history.ProjectHistoryDto;
import com.sofka.bugsmanagement.repositories.history.IProjectHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetProjectHistoryByIdUseCase {
    private final IProjectHistoryRepository repository;
    private final ProjectHistoryMapper mapper;

    public Mono<ProjectHistoryDto> apply(String projectHistoryId) {
        log.info("\n***** Getting History Project by Id: {} *****\n", projectHistoryId);
        return repository
                .findById(projectHistoryId)
                .map(entity -> mapper.convertEntityToDto().apply(entity));
    }
}

