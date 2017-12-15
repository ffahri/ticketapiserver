package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.api.v1.model.TicketDTO;

import java.util.List;
import java.util.Set;

public interface TicketService {
    List<TicketDTO> getAllTickets();
    //List<TicketDTO> getUserAllTicketsById(int userid);
    List<TicketDTO> getAllByUserTicketUsername(String username);
    TicketDTO getTicketById(int id);
    TicketDTO createTicket(TicketDTO ticketDTO);
}
