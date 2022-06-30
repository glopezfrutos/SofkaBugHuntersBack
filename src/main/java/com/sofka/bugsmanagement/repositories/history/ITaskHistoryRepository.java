package com.sofka.bugsmanagement.repositories.history;

import com.sofka.bugsmanagement.collections.history.TaskHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskHistoryRepository extends ReactiveMongoRepository<TaskHistory, String> {
}
