package com.hacker.hl.project.db;

import com.hacker.hl.project.db.entity.ChatMessage;
import com.hacker.hl.project.db.entity.ChatRoom;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ChatMessageDTO {

    private Long chatRoomId;
    private String sender;
    private String senderEmail;
    private String message;

    public ChatMessage toEntity() {
        return ChatMessage.builder()
                .chatRoomId(chatRoomId)
                .sender(sender)
                .senderEmail(senderEmail)
                .message(message)
                .build();
    }
}
