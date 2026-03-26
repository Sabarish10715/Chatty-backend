package com.project.chatty.message;

import lombok.Data;

@Data
public class SendMessageDTO {

    private String conversationId;
    private String content;
    private String type; // TEXT
}
