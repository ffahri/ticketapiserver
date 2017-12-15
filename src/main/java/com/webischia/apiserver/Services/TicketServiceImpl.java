package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Repositories.TicketRepository;
import com.webischia.apiserver.Repositories.UserRepository;
import com.webischia.apiserver.api.v1.mapper.TicketMapper;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService{


    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final UserRepository userRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(ticketMapper::ticketToTicketDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO getTicketById(int id) {
        return ticketMapper.ticketToTicketDTO(ticketRepository.findById(id).get());
    }

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO , String username) {

        Ticket ticket = ticketMapper.ticketDTOtoTicket(ticketDTO);
        ticket.setUserTicket(userRepository.findByUsername(username).get());
        Ticket savedTicket = ticketRepository.save(ticket);
        TicketDTO returnedTicket = ticketMapper.ticketToTicketDTO(savedTicket);
        return returnedTicket;
    }

    @Override
    public List<TicketDTO> getAllTicketsByUsername(String username) {
        return ticketRepository.getAllByUserTicketUsername(username)
                .stream()
                .map(ticketMapper::ticketToTicketDTO)
                .collect(Collectors.toList());

    }

    @Override
    public boolean isUserHaveIt(int id, String username) {
        if(ticketRepository.findById(id).get().getUserTicket().getUsername().equals(username))
            return true;
        else
            return false;
    }
}
