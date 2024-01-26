package com.hacker.hl.project.service;

import com.hacker.hl.project.db.ChatMessageDTO;
import com.hacker.hl.project.db.entity.ChatMessage;
import com.hacker.hl.project.db.entity.ChatRoom;
import com.hacker.hl.project.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageDTO chatMessageDTO;

    public ChatMessage createChat(Long roomId, String sender, String email, String message) {
        chatMessageDTO.setChatRoomId(roomId);
        chatMessageDTO.setSender(sender);
        chatMessageDTO.setSenderEmail(email);
        chatMessageDTO.setMessage(message);

        return chatMessageDTO.toEntity();
    }
}
