package com.sofka.bugsManagment.repositories;

import com.sofka.bugsManagment.collections.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProjectRepository extends ReactiveMongoRepository<Project, String> {
}
