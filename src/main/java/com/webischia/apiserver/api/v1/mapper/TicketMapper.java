package com.webischia.apiserver.api.v1.mapper;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;


public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDTO ticketToTicketDTO(Ticket ticket);

    Ticket ticketDTOtoTicket(TicketDTO ticketDTO);
}
