package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.collections.User;
import com.sofka.bugsmanagement.model.user.UserDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IUserRepository extends ReactiveMongoRepository<User, String> {


    Mono<UserDto> getUserByEmail(String username);
}
