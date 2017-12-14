package com.webischia.apiserver.Bootstrap;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Repositories.TicketRepository;
import com.webischia.apiserver.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TicketBootstrap implements CommandLineRunner {
    private final TicketRepository ticketRepository ;
    private final UserRepository userRepository;

    public TicketBootstrap(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Ticket testTicket = new Ticket();
        testTicket.setStatus(true);
        testTicket.setTicketTitle("Test from Bootstrap");
        testTicket.setUserTicket(userRepository.findById(1).get());
        ticketRepository.save(testTicket);
        System.out.println("Saved = "+ ticketRepository.count());
    }
}
