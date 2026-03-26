package com.project.chatty.conversation;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ConversationMemberRepository memberRepository;

    public String createDirectConversation(String user1, String user2) {

        Conversation conv = Conversation.builder()
                .type("DIRECT")
                .createdBy(user1)
                .createdAt(Instant.now())
                .build();

        conv = conversationRepository.save(conv);

        memberRepository.save(ConversationMember.builder()
                .conversationId(conv.getId())
                .userId(user1)
                .role("MEMBER")
                .joinedAt(Instant.now())
                .build());

        memberRepository.save(ConversationMember.builder()
                .conversationId(conv.getId())
                .userId(user2)
                .role("MEMBER")
                .joinedAt(Instant.now())
                .build());

        return conv.getId();
    }
}
