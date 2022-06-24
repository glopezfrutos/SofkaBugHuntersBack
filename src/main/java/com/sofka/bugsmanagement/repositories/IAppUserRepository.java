package com.sofka.bugsmanagement.repositories;

import com.sofka.bugsmanagement.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
}
