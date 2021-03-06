package com.webischia.apiserver.api.v1.model;

import com.webischia.apiserver.Domains.AccessLevel;
import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.Domains.Ticket;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private String email;

    //
    private String password;
}
