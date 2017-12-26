package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.User;
import com.webischia.apiserver.api.v1.model.UserDTO;
import com.webischia.apiserver.api.v1.model.UserListDTO;

import java.util.List;

public interface UserService {

    void register(UserDTO user);
    void registere(UserDTO user);
    List<User> getAllUsers();
    UserDTO getUserById(int id);
}
