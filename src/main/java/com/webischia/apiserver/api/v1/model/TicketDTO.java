package com.webischia.apiserver.api.v1.model;

import com.webischia.apiserver.Domains.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TicketDTO {


    private int id;
    private String ticketTitle;
    private Set<MessageDTO> messages = new HashSet<>();
    private User userTicket;
    private boolean status;
    private Date creationDate = new Date();
}
