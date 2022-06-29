package com.sofka.bugsmanagement.usecases.user;

import com.sofka.bugsmanagement.mappers.UserMapper;
import com.sofka.bugsmanagement.model.user.Role;
import com.sofka.bugsmanagement.model.user.UserDto;
import com.sofka.bugsmanagement.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogInOrSignInUserUseCase {

    private final IUserRepository repository;
    private final UserMapper mapper;

    public Mono<UserDto> apply(UserDto userDto) {
        return repository
                .findAll()
                .filter(entity -> Objects.equals(entity.getEmail(), userDto.getEmail()))
                .collectList()
                .flatMap(list -> {
                    if(list.isEmpty()) {
                        log.info("\n***** New user created: {} *****\n", userDto.getEmail());
                        return repository
                                .save(mapper.convertDtoToEntity().apply(userDto))
                                .map(entity -> mapper.convertEntityToDto().apply(entity));
                    }
                    else {
                        log.info("\n***** User logged in: {} *****\n", userDto.getEmail());
                        userDto.setId(list.get(0).getId());
                        userDto.setRole(Role.valueOf(list.get(0).getRole()));
                        return repository
                                .save(mapper.convertDtoToEntity().apply(userDto))
                                .map(entity -> mapper.convertEntityToDto().apply(entity));
                    }
                });
    }
}
