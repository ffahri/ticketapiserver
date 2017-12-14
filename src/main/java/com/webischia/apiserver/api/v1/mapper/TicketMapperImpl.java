package com.webischia.apiserver.api.v1.mapper;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketMapperImpl implements TicketMapper {

    private final MessageMapper messageMapper;

    public TicketMapperImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public TicketDTO ticketToTicketDTO(Ticket ticket) {

        if(ticket == null) {
            return null;
        }
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setCreationDate(ticket.getCreationDate());
        ticketDTO.setId(ticket.getId());
        ticketDTO.setStatus(ticket.isStatus());
        ticketDTO.setTicketTitle(ticket.getTicketTitle());
        ticketDTO.setUserTicket(ticket.getUserTicket());
        if(ticket.getMessages() != null && ticket.getMessages().size() > 0)
        {
            ticket.getMessages().forEach(message -> ticketDTO.getMessages().add(messageMapper.messageToMessageDTO(message)));

        }
        return ticketDTO;
    }
}
