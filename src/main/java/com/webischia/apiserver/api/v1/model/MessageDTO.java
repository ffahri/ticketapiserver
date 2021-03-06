package com.webischia.apiserver.api.v1.model;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Domains.User;
import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {


    private int id;
    private String messageContext;
    /*private TicketDTO ticketMessage;*/
    private UserDTO userMessage;
    private Date creationDate = new Date();

}
