package com.webischia.apiserver.api.v1.mapper;

import com.webischia.apiserver.Domains.Ticket;
import com.webischia.apiserver.Domains.User;
import com.webischia.apiserver.api.v1.model.OnlyTicketDTO;
import com.webischia.apiserver.api.v1.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);



}
