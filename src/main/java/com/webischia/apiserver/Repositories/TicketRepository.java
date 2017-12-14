package com.webischia.apiserver.Repositories;

import com.webischia.apiserver.Domains.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    Optional<Ticket> findById(int id);
    Optional<Ticket> getAllByStatus(Boolean status);
    Optional<Ticket> findByTicketTitle(String title);
}