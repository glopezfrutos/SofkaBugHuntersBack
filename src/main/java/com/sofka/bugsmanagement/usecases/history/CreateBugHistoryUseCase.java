package com.sofka.bugsmanagement.usecases.history;

import com.sofka.bugsmanagement.mappers.BugHistoryMapper;
import com.sofka.bugsmanagement.model.history.BugHistoryDto;
import com.sofka.bugsmanagement.repositories.history.IBugHistoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service

@RequiredArgsConstructor
@Slf4j
public class CreateBugHistoryUseCase {
    private final IBugHistoryRepository repository;
    private final BugHistoryMapper mapper;

    public Mono<BugHistoryDto> apply(BugHistoryDto bugHistoryDto) {
        log.info("\n**** New Bug History created Id: {} *****\n", bugHistoryDto.getId());
        return repository
                .save(mapper.convertDtoToEntity().apply(bugHistoryDto))
                        .map(dto -> mapper
                                .convertEntityToDto()
                                .apply(dto));
    }
}
