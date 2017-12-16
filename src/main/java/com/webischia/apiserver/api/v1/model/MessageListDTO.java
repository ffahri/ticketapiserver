package com.webischia.apiserver.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class MessageListDTO {
    List<MessageDTO> messages;
}
