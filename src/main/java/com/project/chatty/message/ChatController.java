package com.project.chatty.message;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.send")
    public void sendMessage(@Payload SendMessageDTO dto,
                            Principal principal) {

        String userId = principal.getName();

        Message saved = messageService.saveMessage(userId, dto);

        messagingTemplate.convertAndSend(
                "/topic/conversations/" + dto.getConversationId(),
                saved
        );
    }
}
