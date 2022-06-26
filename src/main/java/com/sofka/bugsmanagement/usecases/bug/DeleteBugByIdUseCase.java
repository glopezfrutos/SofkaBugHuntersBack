package com.sofka.bugsmanagement.usecases.bug;

import com.sofka.bugsmanagement.repositories.IBugRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteBugByIdUseCase {
    private final IBugRepository bugRepository;

    public Mono<Void> apply(String id){
        return bugRepository.deleteById(id);
    }
}
