package com.sofka.bugsmanagement.repositories;


import com.sofka.bugsmanagement.entities.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBugRepository extends JpaRepository<Bug, Long> {
}
