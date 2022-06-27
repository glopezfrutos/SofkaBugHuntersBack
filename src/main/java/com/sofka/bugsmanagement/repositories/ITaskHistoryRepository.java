package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.collections.TaskHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskHistoryRepository extends ReactiveMongoRepository<TaskHistory, String> {
}
