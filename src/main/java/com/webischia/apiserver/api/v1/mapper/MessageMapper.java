package com.webischia.apiserver.api.v1.mapper;

import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.api.v1.model.MessageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDTO messageToMessageDTO(Message message);
}
