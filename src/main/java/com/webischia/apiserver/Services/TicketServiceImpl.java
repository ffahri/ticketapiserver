package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Repositories.TicketRepository;
import com.webischia.apiserver.api.v1.mapper.TicketMapper;
import com.webischia.apiserver.api.v1.model.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService{


    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
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
    public TicketDTO createTicket(TicketDTO ticketDTO) {

        Ticket ticket = ticketMapper.ticketDTOtoTicket(ticketDTO);
        Ticket savedTicket = ticketRepository.save(ticket);
        TicketDTO returnedTicket = ticketMapper.ticketToTicketDTO(savedTicket);
        return returnedTicket;
    }
}
