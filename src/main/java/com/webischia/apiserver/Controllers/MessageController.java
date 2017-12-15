package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.Services.MessageService;
import com.webischia.apiserver.Services.TicketService;
import com.webischia.apiserver.api.v1.model.MessageDTO;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService messageService;
    private final TicketService ticketService;

    public MessageController(MessageService messageService, TicketService ticketService) {
        this.messageService = messageService;
        this.ticketService = ticketService;
    }

    private ResponseEntity<MessageDTO> getMessageById()
    {
        return null;
    }

    @PostMapping("/api/v1/tickets/{id}/newMessage")
    public ResponseEntity<MessageDTO> createTicket(@RequestBody MessageDTO MessageDTO, @PathVariable int id)
    {
        return new ResponseEntity<MessageDTO>(messageService.createMessage(MessageDTO,id), HttpStatus.CREATED);
    }
}
