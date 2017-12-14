package com.webischia.apiserver.Controllers;

import com.webischia.apiserver.api.v1.model.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/messages")
public class MessageController {

    private ResponseEntity<MessageDTO> getMessageById()
    {
        return null;
    }

}
