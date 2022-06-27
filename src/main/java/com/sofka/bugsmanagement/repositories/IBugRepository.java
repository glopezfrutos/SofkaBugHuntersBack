package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.collections.Bug;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBugRepository extends ReactiveMongoRepository<Bug, String> {
}
