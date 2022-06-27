package com.sofka.bugsmanagement.usecases.user;

import com.sofka.bugsmanagement.mappers.UserMapper;
import com.sofka.bugsmanagement.model.user.UserDto;
import com.sofka.bugsmanagement.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUserUseCase {

    private final IUserRepository repository;
    private final UserMapper mapper;

    public Mono<UserDto> apply(UserDto userDto) {
        log.info("\n***** New user created: {} *****\n", userDto.getEmail());
        return repository
                .save(mapper.convertDtoToEntity().apply(userDto))
                .map(dto -> mapper
                        .convertEntityToDto()
                        .apply(dto));
    }
}
