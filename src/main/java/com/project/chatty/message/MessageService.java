package com.project.chatty.message;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(String userId, SendMessageDTO dto) {

        Message msg = Message.builder()
                .conversationId(dto.getConversationId())
                .senderId(userId)
                .content(dto.getContent())
                .type(dto.getType())
                .createdAt(Instant.now())
                .status("SENT")
                .build();

        return messageRepository.save(msg);
    }
}
