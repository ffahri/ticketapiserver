package com.webischia.apiserver.Services;

import com.webischia.apiserver.api.v1.model.MessageDTO;

import java.util.List;

public interface MessageService {

    List<MessageDTO> getAllMessages();
    MessageDTO getMessageById(int id);
}
