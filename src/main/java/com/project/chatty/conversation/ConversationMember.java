package com.project.chatty.conversation;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "conversation_members")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndexes({
    @CompoundIndex(name = "uniq_conv_user", def = "{'conversationId': 1, 'userId': 1}", unique = true),
    @CompoundIndex(name = "idx_user", def = "{'userId': 1}")
})
public class ConversationMember {

    @Id
    private String id;

    private String conversationId;

    private String userId;

    private String role; // ADMIN | MEMBER

    private Instant joinedAt;

    private String lastReadMessageId;
}
