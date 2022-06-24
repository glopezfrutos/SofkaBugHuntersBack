package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagRepository extends JpaRepository<Tag, Long> {
}
