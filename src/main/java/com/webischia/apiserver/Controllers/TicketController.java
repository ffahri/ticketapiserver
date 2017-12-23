package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Repositories.UserRepository;
import com.webischia.apiserver.Services.TicketService;
import com.webischia.apiserver.api.v1.model.OnlyTicketListDTO;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import com.webischia.apiserver.api.v1.model.TicketListDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
@RequestMapping({"/api/v1/tickets/","/api/v1/tickets"})
public class TicketController {

    private final TicketService ticketService;
    private final UserRepository userRepository;

    public TicketController(TicketService ticketService, UserRepository userRepository) {
        this.ticketService = ticketService;
        this.userRepository = userRepository;
    }


    @PreAuthorize("hasAuthority('Employee')")
    @GetMapping
    public ResponseEntity<TicketListDTO> getAllTickets()
    {
        return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllTickets()),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Client') or hasAuthority('Employee')")
    @GetMapping("/user/{name}")
    public ResponseEntity<TicketListDTO> getUserAllTicketsByUserName(@PathVariable String name) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userWhichRequest = authentication.getName();
            if (name.equals(userWhichRequest)) {
                return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllTicketsByUsername(name)), HttpStatus.OK);
            }
        else if (userRepository.findByUsername(userWhichRequest).get().getAccessLevel().getDescription().equals("Employee"))
        {
            return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.getAllTicketsByUsername(name)),HttpStatus.OK);

        }
        else
            throw new AccessDeniedException("Wrong User || Hatalı Kullanıcı");
    }


    @PreAuthorize("hasAuthority('Employee')")
    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable int id)
    {
        return new ResponseEntity<TicketDTO>(ticketService.getTicketById(id),HttpStatus.OK);
    }




//*******************************************************************************

    // BUNU USER KULLANACAK
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


    //SEARCH

    @PreAuthorize("hasAuthority('Client')")
    @GetMapping("/user/{name}/search/{term}")
    public ResponseEntity<TicketListDTO> userSearchTicket(@PathVariable String name,@PathVariable(value = "term") String term)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userWhichRequest = authentication.getName();
        if (name.equals(userWhichRequest)) {
            int id = userRepository.findByUsername(name).get().getId();
            return new ResponseEntity<TicketListDTO>(new TicketListDTO(ticketService.findAllByTicketTitle(id,term)), HttpStatus.OK);
        }
        else
            throw new AccessDeniedException("Wrong User || Hatalı Kullanıcı");


    }
    // UPDATE

    @PreAuthorize("hasAuthority('Client')")
    @GetMapping("/user/{name}/{id}/status")
    public void closeOrOpenTicketclient(@PathVariable String name, @PathVariable int id)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userWhichRequest = authentication.getName();
        if (name.equals(userWhichRequest)) {
            ticketService.CloseOrOpenTicket(id);
        }
        else
            throw new AccessDeniedException("Wrong User || Hatalı Kullanıcı");

    }

    @PreAuthorize("hasAuthority('Employee')")
    @GetMapping("/{id}/status")
    public void closeOrOpenTicket(@PathVariable int id)
    {
        ticketService.CloseOrOpenTicket(id);

    }

}
