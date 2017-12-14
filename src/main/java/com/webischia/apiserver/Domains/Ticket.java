package com.webischia.apiserver.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"messages","userTicket"})
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ticketTitle;

    @OneToMany(mappedBy = "ticketMessage")
    private Set<Message> messages = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User userTicket;

    private boolean status;

    @Temporal(TemporalType.TIMESTAMP) //todo kontrol edelim elle girerken filan data.sql ile olmadı
    private Date creationDate = new Date();


}
