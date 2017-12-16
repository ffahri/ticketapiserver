package com.webischia.apiserver.api.v1.model;

import com.webischia.apiserver.Domains.User;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class OnlyTicketDTO {




    private int id;
    private String ticketTitle;
    //private Set<MessageDTO> messages = new HashSet<>();
    private UserDTO userTicket;
    private boolean status;
    private Date creationDate = new Date();
}
