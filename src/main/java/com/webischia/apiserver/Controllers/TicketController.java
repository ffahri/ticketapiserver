package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Services.TicketService;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import com.webischia.apiserver.api.v1.model.TicketListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('Client') or hasAuthority('Employee')")
    @GetMapping("{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable int id)
    {
        return new ResponseEntity<TicketDTO>(ticketService.getTicketById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Client') or hasAuthority('Employee')")
    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO)
    {
        return new ResponseEntity<TicketDTO>(ticketService.createTicket(ticketDTO),HttpStatus.CREATED);
    }


}
