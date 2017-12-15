package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Services.TicketService;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import com.webischia.apiserver.api.v1.model.TicketListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/v1/tickets/","/api/v1/tickets"})
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PreAuthorize("hasAuthority('Client') or hasAuthority('Employee')")
    @GetMapping
    public ResponseEntity<TicketListDTO> getAllTickets()
    {
        return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllTickets()),HttpStatus.OK);
    }
   /* @PreAuthorize("#contact.name == authentication.name")
    public void doSomething(Contact contact);*/
    @PreAuthorize("hasAuthority('Client') or hasAuthority('Employee')")
    @GetMapping("{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable int id)
    {
        return new ResponseEntity<TicketDTO>(ticketService.getTicketById(id),HttpStatus.OK);
    }

    // BUNU USER KULLANACAK
    @PreAuthorize("hasAuthority('Client')")
    @GetMapping("/user/{name}")
    public ResponseEntity<TicketListDTO> getUserAllTicketsByUserName(@PathVariable String name)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userWhichRequest = authentication.getName();
        if(name.equals(userWhichRequest)) {
            return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllByUserTicketUsername(name)), HttpStatus.OK);
        }
        else
            throw new RuntimeException(); // todo normal bir hata mesajı verelim
    }



    @PreAuthorize("hasAuthority('Client') or hasAuthority('Employee')")
    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO)
    {
        return new ResponseEntity<TicketDTO>(ticketService.createTicket(ticketDTO),HttpStatus.CREATED);
    }


}
