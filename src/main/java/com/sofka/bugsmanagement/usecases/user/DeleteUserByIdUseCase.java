package com.sofka.bugsmanagement.usecases.user;

import com.sofka.bugsmanagement.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteUserByIdUseCase {
    private final IUserRepository repository;

    public Mono<Void> apply(String id){
        log.info("\n***** User deleted. Id: {} *****\n", id);
        return repository.deleteById(id);
    }
}
