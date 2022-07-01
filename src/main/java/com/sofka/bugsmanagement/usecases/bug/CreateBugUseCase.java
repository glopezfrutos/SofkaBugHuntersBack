package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.mappers.BugHistoryMapper;
import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import com.sofka.bugsmanagement.repositories.history.IBugHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class CreateBugUseCase {
    private final IBugRepository repository;
    private final BugMapper mapper;

    private final IBugHistoryRepository bugHistoryRepository;
    private final BugHistoryMapper bugHistoryMapper;

    public Mono<BugDto> apply(@Valid BugDto bugDto) {
        log.info("\n***** New Bug created Id: {} *****\n", bugDto.getId());
        return  bugHistoryRepository
                .save(bugHistoryMapper
                        .convertBugDtoToBugHistory()
                        .apply(bugDto))
                .then(
                repository
                .save(mapper
                        .convertDtoToEntity()
                        .apply(bugDto))
                .map(dto -> mapper
                        .convertEntityToDto()
                        .apply(dto)));
    }
}
