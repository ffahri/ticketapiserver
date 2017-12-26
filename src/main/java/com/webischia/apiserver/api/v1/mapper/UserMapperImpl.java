//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.webischia.apiserver.api.v1.mapper;

import com.webischia.apiserver.Domains.User;
import com.webischia.apiserver.api.v1.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    public UserMapperImpl() {
    }

    public UserDTO userToUserDTO(User user) {
        if (user == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getUsername());
            userDTO.setSurname(user.getName());
            userDTO.setEmail(user.getEmail());
           // userDTO.setPassword(user.getPassword());
            return userDTO;
        }
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setUsername(userDTO.getName());
            user.setName(userDTO.getSurname());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            return user;
        }
    }
}
