/*
package com.webischia.apiserver.api.v1.mapper;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import org.springframework.stereotype.Component;

*/
/*@Component*//*

public class AAATicketMapperImpl implements TicketMapper {

    private final MessageMapper messageMapper;
    private final UserMapper userMapper;

    public AAATicketMapperImpl(MessageMapper messageMapper, UserMapper userMapper) {
        this.messageMapper = messageMapper;
        this.userMapper = userMapper;
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
        ticketDTO.setUserTicket(userMapper.userToUserDTO(ticket.getUserTicket()));
 if(ticket.getMessages() != null && ticket.getMessages().size() > 0)
        {
            ticket.getMessages().forEach(message -> ticketDTO.getMessages().add(messageMapper.messageToMessageDTO(message)));

        }

        return ticketDTO;
    }

    @Override
    public Ticket ticketDTOtoTicket(TicketDTO ticket) {
        if(ticket == null) {
            return null;
        }
        Ticket ticketDTO = new Ticket();
        ticketDTO.setCreationDate(ticket.getCreationDate());
        ticketDTO.setId(ticket.getId());
        ticketDTO.setStatus(ticket.isStatus());
        ticketDTO.setTicketTitle(ticket.getTicketTitle());
        ticketDTO.setUserTicket(userMapper.userDTOToUser(ticket.getUserTicket()));
if(ticket.getMessages() != null && ticket.getMessages().size() > 0)
        {
            ticket.getMessages().forEach(messageDTO -> ticketDTO.getMessages().add(messageMapper.messageDTOtoMessage(messageDTO)));

        }

        return ticketDTO;
    }
}
*/
