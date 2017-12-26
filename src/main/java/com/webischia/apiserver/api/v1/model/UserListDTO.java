package com.webischia.apiserver.api.v1.model;

import com.webischia.apiserver.Domains.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserListDTO {
    List<User> users;
}
