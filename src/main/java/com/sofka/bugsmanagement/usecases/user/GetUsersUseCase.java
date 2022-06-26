package com.sofka.bugsmanagement.usecases.user;

import com.sofka.bugsmanagement.mappers.UserMapper;
import com.sofka.bugsmanagement.model.user.UserDto;
import com.sofka.bugsmanagement.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUsersUseCase implements Supplier<Flux<UserDto>> {

    private final IUserRepository repository;
    private final UserMapper mapper;


    @Override
    public Flux<UserDto> get() {
        log.info("*** Get all users ***");
        return repository
                .findAll()
                .map(dto -> mapper
                        .convertEntityToDto()
                        .apply(dto));
    }
}
