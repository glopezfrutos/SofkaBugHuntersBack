package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.collections.Bug;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IBugRepository extends ReactiveMongoRepository<Bug, String> {
}
