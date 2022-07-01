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
public class UpdateUserRoleUseCase {

    private final IUserRepository repository;
    private final UserMapper mapper;

    public Mono<UserDto> apply(UserDto userDto) {
        return repository
                .findAll()
                .filter(entity -> Objects.equals(entity.getEmail(), userDto.getEmail()))
                .collectList()
                .flatMap(list -> {
                    userDto.setId(list.get(0).getId());
                    userDto.setSessionId(list.get(0).getSessionId());
                    log.info("\n***** Role updated to {} for User {}  *****\n", userDto.getRole(), userDto.getEmail());
                    return repository
                            .save(mapper.convertDtoToEntity().apply(userDto))
                            .map(entity -> mapper.convertEntityToDto().apply(entity));
                });
    }
}
