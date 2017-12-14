package com.webischia.apiserver.Services;

import com.webischia.apiserver.api.v1.model.TicketDTO;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getAllTickets();
    TicketDTO getTicketById(int id);
}
