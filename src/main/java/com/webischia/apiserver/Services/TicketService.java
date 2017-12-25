package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.api.v1.model.OnlyTicketDTO;
import com.webischia.apiserver.api.v1.model.TicketDTO;

import java.util.List;
import java.util.Set;

public interface TicketService {
    List<TicketDTO> getAllTickets();
    //List<TicketDTO> getUserAllTicketsById(int userid);
    List<TicketDTO> getAllTicketsByUsername(String username);
    TicketDTO getTicketById(int id);
    TicketDTO createTicket(TicketDTO ticketDTO,String username);
    boolean isUserHaveIt(int id , String username);
    List<TicketDTO> findAllByTicketTitle(int id,String title);
    TicketDTO patchTicket(int id, TicketDTO ticketDTO);
    public void CloseOrOpenTicket(int id);
    void deleteById(int id);

}
