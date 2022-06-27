package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends ReactiveMongoRepository<User, String> {
}
