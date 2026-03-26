package com.project.chatty.message;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "messages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndexes({
    @CompoundIndex(name = "idx_conv_created", def = "{'conversationId': 1, 'createdAt': -1}"),
    @CompoundIndex(name = "idx_conv_id", def = "{'conversationId': 1, '_id': -1}"),
    @CompoundIndex(name = "uniq_client_msg", def = "{'clientMessageId': 1}", unique = true)
})
public class Message {

    @Id
    private String id;

    private String conversationId;

    private String senderId;

    private String content;

    private String type; // TEXT | IMAGE | FILE

    private Instant createdAt;

    private String clientMessageId;

    private String replyTo;

    private String status; // SENT
}
