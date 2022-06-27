package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.collections.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends ReactiveMongoRepository<Task, String> {
}
