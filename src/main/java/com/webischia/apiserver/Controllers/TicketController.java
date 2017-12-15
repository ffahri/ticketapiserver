package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Services.TicketService;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import com.webischia.apiserver.api.v1.model.TicketListDTO;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping({"/api/v1/tickets/","/api/v1/tickets"})
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PreAuthorize("hasAuthority('Employee')")
    @GetMapping
    public ResponseEntity<TicketListDTO> getAllTickets()
    {
        return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllTickets()),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Employee')")
    @GetMapping("/get/{name}")
    public ResponseEntity<TicketListDTO> getAllTicketsbyUsername(@PathVariable String name)
    {
        return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllTicketsByUsername(name)),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Employee')")
    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable int id)
    {
        return new ResponseEntity<TicketDTO>(ticketService.getTicketById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Client')")
    @GetMapping("/user/{name}/{id}")
    public ResponseEntity<TicketDTO> userGetById(@PathVariable int id,@PathVariable String name)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userWhichRequest = authentication.getName();
        if(name.equals(userWhichRequest) && ticketService.isUserHaveIt(id,name)) { // kullanıcı sahip mi buna yoksa heykır ??
            return new ResponseEntity<TicketDTO>(ticketService.getTicketById(id), HttpStatus.OK);
        }
        else
            throw new AccessDeniedException("Wrong User || Hatalı Kullanıcı");
    }


    // BUNU USER KULLANACAK
    @PreAuthorize("hasAuthority('Client')")
    @GetMapping("/user/{name}")
    public ResponseEntity<TicketListDTO> getUserAllTicketsByUserName(@PathVariable String name)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userWhichRequest = authentication.getName();
        if(name.equals(userWhichRequest)) {
            return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllTicketsByUsername(name)), HttpStatus.OK);
        }
        else
            throw new AccessDeniedException("Wrong User || Hatalı Kullanıcı");
    }



    @PreAuthorize("hasAuthority('Client')")
    @PostMapping("/user/{name}")
    public ResponseEntity<TicketDTO> userCreateTicket(@RequestBody TicketDTO ticketDTO,@PathVariable String name)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userWhichRequest = authentication.getName();
        if(name.equals(userWhichRequest)) {
            return new ResponseEntity<TicketDTO>(ticketService.createTicket(ticketDTO,name), HttpStatus.CREATED);
        }
        else
            throw new AccessDeniedException("Wrong User || Hatalı Kullanıcı");


    }
}
