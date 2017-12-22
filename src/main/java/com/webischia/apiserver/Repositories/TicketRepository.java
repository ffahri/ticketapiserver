package com.webischia.apiserver.Repositories;

import com.webischia.apiserver.Domains.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    Optional<Ticket> findById(int id);
    Optional<Ticket> getAllByStatus(Boolean status);
    Optional<Ticket> findByTicketTitle(String title);
    //List<Ticket> getAllByUserTicket(String name);
    List<Ticket> getAllByUserTicketUsername(String username);
    List<Ticket> findAllByUserTicketIdAndTicketTitleContaining(int id,String title);
}
