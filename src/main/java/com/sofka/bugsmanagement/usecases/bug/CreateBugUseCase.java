package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.function.Function;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class CreateBugUseCase {
    private final IBugRepository repository;
    private final BugMapper mapper;

    public Mono<BugDto> apply(@Valid BugDto bugDto) {
        log.info("*** New Bug created *** Id: {}", bugDto.getId());
        return repository
                .save(mapper.convertDtoToEntity().apply(bugDto))
                .map(dto -> mapper
                        .convertEntityToDto()
                        .apply(dto));
    }
}
