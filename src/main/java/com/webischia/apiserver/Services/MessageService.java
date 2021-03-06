package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.api.v1.model.MessageDTO;

import java.util.List;

public interface MessageService {

    List<MessageDTO> getAllMessages(int id);
    MessageDTO getMessageById(int id);
    MessageDTO createMessage(MessageDTO messageDTO , int id , String username); //hangi idye sahip tickete ekleyeceğim
}
