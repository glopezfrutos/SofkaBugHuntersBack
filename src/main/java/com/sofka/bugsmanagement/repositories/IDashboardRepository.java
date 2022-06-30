package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.collections.Dashboard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDashboardRepository extends ReactiveMongoRepository<Dashboard, String> {
}
