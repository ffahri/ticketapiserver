package com.webischia.apiserver.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"accessLevel","ticketSet","messages"})
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private String phone;
    @JsonIgnore
    private String password;

    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_id", nullable = false)
    private AccessLevel accessLevel;

   /* @OneToMany(mappedBy = "userTicket")
    private Set<Ticket> ticketSet = new HashSet<>();
*/
/*    @OneToMany(mappedBy = "userMessage")
    private Set<Message> messages = new HashSet<>();*/
}
