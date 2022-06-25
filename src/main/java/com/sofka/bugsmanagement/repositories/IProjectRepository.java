package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.collections.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends ReactiveMongoRepository<Project, String> {
}
