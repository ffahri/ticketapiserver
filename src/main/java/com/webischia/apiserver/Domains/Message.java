package com.webischia.apiserver.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@EqualsAndHashCode(exclude = {"ticketMessage","userMessage"})
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String messageContext;

    @ManyToOne
    @JoinColumn(name="ticket_id" , nullable = false)// bir mesaj yalnız ve yalnız bir kullanıcıya ait olabilir.
    private Ticket ticketMessage;

    @ManyToOne
    @JoinColumn(name="user_id" , nullable = false)
    private User userMessage;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();



}
