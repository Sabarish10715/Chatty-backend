package com.project.chatty.conversation;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @PostMapping("/direct")
    public Map<String, String> create(@RequestBody Map<String, String> req,
                                      Principal principal) {

        String user1 = principal.getName();
        String user2 = req.get("userId");

        String convId = conversationService.createDirectConversation(user1, user2);

        return Map.of("conversationId", convId);
    }
}
