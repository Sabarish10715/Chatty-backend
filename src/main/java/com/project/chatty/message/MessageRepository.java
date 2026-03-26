package com.project.chatty.message;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {

    boolean existsByClientMessageId(String clientMessageId);
}