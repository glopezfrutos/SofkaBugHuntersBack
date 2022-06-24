package com.sofka.bugsManagment.repositories;

import com.sofka.bugsManagment.entities.Ticket;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ITicketRepository extends ReactiveMongoRepository<Ticket, String> {
}
