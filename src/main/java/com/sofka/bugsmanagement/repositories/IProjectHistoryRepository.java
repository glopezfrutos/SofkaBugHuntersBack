package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.collections.ProjectHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectHistoryRepository extends ReactiveMongoRepository<ProjectHistory, String> {
}
