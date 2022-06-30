package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.collections.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface IProjectPageableRepository extends ReactiveCrudRepository<Project, String> {
    @Query("{ id: { $exists: true }}")
    Flux<Project> retrieveAllProjectsPaged(final Pageable page);
}
