package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IUserRepository extends ReactiveMongoRepository<User, String> {
}
