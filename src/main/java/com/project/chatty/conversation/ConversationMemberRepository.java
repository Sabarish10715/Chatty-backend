package com.project.chatty.conversation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationMemberRepository extends MongoRepository<ConversationMember, String> {

    List<ConversationMember> findByUserId(String userId);

    Optional<ConversationMember> findByConversationIdAndUserId(String conversationId, String userId);
}
