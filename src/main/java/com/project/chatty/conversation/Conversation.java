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

@Document(collection = "conversations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndexes({
    @CompoundIndex(name = "idx_createdAt", def = "{'createdAt': -1}")
})
public class Conversation {

    @Id
    private String id;

    private String type; // DIRECT | GROUP

    private String name; // for group

    private String createdBy;

    private Instant createdAt;

    private String lastMessageId;
}
