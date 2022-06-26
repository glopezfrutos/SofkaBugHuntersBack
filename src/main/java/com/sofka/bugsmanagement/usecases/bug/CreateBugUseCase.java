package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.mappers.BugMapper;
import com.sofka.bugsmanagement.model.bug.BugDto;
import com.sofka.bugsmanagement.repositories.IBugRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateBugUseCase implements Function<BugDto, Mono<BugDto>> {

    private final IBugRepository repository;
    private final BugMapper mapper;

    @Override
    public Mono<BugDto> apply(BugDto bugDto) {
        log.info("*** New Bug created *** Id: {}", bugDto.getId());
        return repository
                .save(mapper.convertDtoToEntity().apply(bugDto))
                .map(dto -> mapper
                        .convertEntityToDto()
                        .apply(dto));
    }
}
