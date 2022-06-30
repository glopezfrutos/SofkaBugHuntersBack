package com.sofka.bugsmanagement.usecases.dashboard;

import com.sofka.bugsmanagement.mappers.BugMapper;

import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.model.bug.BugStatus;

import com.sofka.bugsmanagement.repositories.IBugRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetDashboardUseCase {

    private final IBugRepository repository;
    private final BugMapper mapper;

    public Flux<BugDto> get() {
        log.info("\n***** Getting dashboard *****\n");
        return repository
                .findAll().map(dto -> mapper
                        .convertEntityToDto()
                        .apply(dto)).filter(bugDto -> !bugDto.getStatus().equals(BugStatus.SOLVED));
    }
}
