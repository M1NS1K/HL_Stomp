package com.hacker.hl.project.repository;

import com.hacker.hl.project.db.ChatMessageDTO;
import com.hacker.hl.project.db.entity.ChatMessage;
import com.hacker.hl.project.db.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatMessageRepository {

    private final ChatMessageDTO chatMessageDTO;

    public ChatMessage createChatMessage() {
        ChatMessage room = chatMessageDTO.toEntity();
        return room;
    }
}
