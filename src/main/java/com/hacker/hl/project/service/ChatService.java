package com.hacker.hl.project.service;

import com.hacker.hl.project.entity.Chat;
import com.hacker.hl.project.entity.ChatRoom;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public Chat createChat(Long roomId, String sender, String senderEmail, String message) {
        ChatRoom chatRoom = ChatRoom.builder().name("room").build();
        return Chat.builder()
                .room(chatRoom)
                .id(roomId)
                .sender(sender)
                .senderEmail(senderEmail)
                .message(message)
                .build();
    }
}
