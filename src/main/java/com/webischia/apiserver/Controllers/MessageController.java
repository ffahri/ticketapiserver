package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.Services.MessageService;
import com.webischia.apiserver.Services.TicketService;
import com.webischia.apiserver.api.v1.model.MessageDTO;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @PreAuthorize("hasAuthority('Client')")
    @PostMapping("{username}/{id}/new")
    public ResponseEntity<MessageDTO> createTicket(@RequestBody MessageDTO MessageDTO, @PathVariable int id, @PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userWhichRequest = authentication.getName();
        if (username.equals(userWhichRequest) && ticketService.isUserHaveIt(id, username)) { // bu kullanıcı bu ticketa sahip mi ?
            return new ResponseEntity<MessageDTO>(messageService.createMessage(MessageDTO, id,username), HttpStatus.CREATED);
        }
        else
            throw new AccessDeniedException("Wrong User || Hatalı Kullanıcı || Message Service");
    }
}
