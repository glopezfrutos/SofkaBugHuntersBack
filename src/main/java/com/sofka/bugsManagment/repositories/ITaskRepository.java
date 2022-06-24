package com.sofka.bugsManagment.repositories;

import com.sofka.bugsManagment.collections.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ITaskRepository extends ReactiveMongoRepository<Task, String> {
}
