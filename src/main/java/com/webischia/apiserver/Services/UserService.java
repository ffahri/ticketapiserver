package com.webischia.apiserver.Services;

import com.webischia.apiserver.api.v1.model.UserDTO;
import com.webischia.apiserver.api.v1.model.UserListDTO;

import java.util.List;

public interface UserService {

    void register(UserDTO user);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(int id);
}
