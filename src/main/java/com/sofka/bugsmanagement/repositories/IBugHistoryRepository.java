package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.collections.Bug;
import com.sofka.bugsmanagement.collections.BugHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBugHistoryRepository extends ReactiveMongoRepository<BugHistory, String> {
}
