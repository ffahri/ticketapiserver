package com.webischia.apiserver.Services;

import com.webischia.apiserver.Repositories.MessageRepository;
import com.webischia.apiserver.api.v1.mapper.MessageMapper;
import com.webischia.apiserver.api.v1.model.MessageDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MessageServiceImpl implements MessageService{


    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll()  //Java 8 Stream
                .stream()
                .map(messageMapper::messageToMessageDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO getMessageById(int id) {
        return messageMapper.messageToMessageDTO(messageRepository.findById(id).get());
    }
}
