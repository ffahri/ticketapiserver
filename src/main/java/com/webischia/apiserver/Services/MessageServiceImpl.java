package com.webischia.apiserver.Services;

import com.webischia.apiserver.Domains.Message;
import com.webischia.apiserver.Repositories.MessageRepository;
import com.webischia.apiserver.Repositories.TicketRepository;
import com.webischia.apiserver.Repositories.UserRepository;
import com.webischia.apiserver.api.v1.mapper.MessageMapper;
import com.webischia.apiserver.api.v1.model.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService{


    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper,
                              TicketRepository ticketRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
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

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO, int id , String username) {
        if(messageDTO == null)
            return null;

        Message gelen = messageMapper.messageDTOtoMessage(messageDTO);
        gelen.setTicketMessage(ticketRepository.findById(id).get());
        gelen.setUserMessage(userRepository.findByUsername(username).get());//Aşırı hardcoded yaparken
        Message giden = messageRepository.save(gelen);
        MessageDTO geridonen = messageMapper.messageToMessageDTO(giden);

        return geridonen;
    }
}
