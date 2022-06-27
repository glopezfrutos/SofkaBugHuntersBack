package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.repositories.IBugRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteBugByIdUseCase {
    private final IBugRepository repository;

    public Mono<Void> apply(String id){
        log.info("\n***** Bug deleted. Id: {} *****\n", id);
        return repository.deleteById(id);
    }
}
