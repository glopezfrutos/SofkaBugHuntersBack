package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.collections.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ITaskRepository extends ReactiveMongoRepository<Task, String> {
}
