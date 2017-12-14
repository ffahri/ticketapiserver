package com.webischia.apiserver.api.v1.model;

import com.webischia.apiserver.Domains.User;

import java.util.Date;

public class MessageDTO {


    private int id;
    private String messageContext;
    private TicketDTO ticketMessage;
    private User userMessage;
    private Date creationDate = new Date();

}
