package com.webischia.apiserver.Bootstrap;

import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Repositories.MessageRepository;
import com.webischia.apiserver.Repositories.TicketRepository;
import com.webischia.apiserver.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TicketBootstrap implements CommandLineRunner {
    private final TicketRepository ticketRepository ;
    private final UserRepository userRepository;

    private final MessageRepository messageRepository;

    public TicketBootstrap(TicketRepository ticketRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Ticket testTicket = new Ticket();
        testTicket.setStatus(true);
        testTicket.setTicketTitle("Test from Bootstrap");
        testTicket.setUserTicket(userRepository.findById(1).get());
        ticketRepository.save(testTicket);
        Message testMessage = new Message();
        testMessage.setMessageContext("İlk Mesaj Hey");
        testMessage.setUserMessage(userRepository.findById(1).get());
        testMessage.setTicketMessage(ticketRepository.findById(1).get());
        messageRepository.save(testMessage);

        Ticket testTicket2 = new Ticket();
        testTicket2.setStatus(true);
        testTicket2.setTicketTitle("TICKET 2");
        testTicket2.setUserTicket(userRepository.findById(2).get());
        ticketRepository.save(testTicket2);
        Message testMessage2 = new Message();
        testMessage2.setMessageContext("İkinci Mesaj Hey");
        testMessage2.setUserMessage(userRepository.findById(2).get());
        testMessage2.setTicketMessage(ticketRepository.findById(2).get());
        messageRepository.save(testMessage2);
        System.out.println("Saved = "+ ticketRepository.count());
        //System.out.println("LOL = "+ticketRepository.findById(1).get().getMessages().iterator().next().getMessageContext());
    }
}
