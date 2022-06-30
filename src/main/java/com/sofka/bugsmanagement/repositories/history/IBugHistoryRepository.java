package com.sofka.bugsmanagement.repositories.history;

import com.sofka.bugsmanagement.collections.history.BugHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBugHistoryRepository extends ReactiveMongoRepository<BugHistory, String> {
}
