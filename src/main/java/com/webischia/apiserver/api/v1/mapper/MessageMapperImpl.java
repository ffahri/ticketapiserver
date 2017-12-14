package com.webischia.apiserver.api.v1.mapper;

import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.api.v1.model.MessageDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageMapperImpl implements MessageMapper {

    /*private final TicketMapper ticketMapper;

    public MessageMapperImpl(TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }*/

    @Override
    public MessageDTO messageToMessageDTO(Message message) {

        if(message==null) {
            return null;
        }
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCreationDate(message.getCreationDate());
        messageDTO.setId(message.getId());
        messageDTO.setMessageContext(message.getMessageContext());
        //messageDTO.setTicketMessage(ticketMapper.ticketToTicketDTO(message.getTicketMessage()));
        messageDTO.setUserMessage(message.getUserMessage());

        return messageDTO;
    }
}
