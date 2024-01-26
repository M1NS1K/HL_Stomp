package com.hacker.hl.project.db;

import com.hacker.hl.project.db.entity.ChatMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {

    private String sender;
    private String senderEmail;
    private String message;

    public ChatMessage toEntity() {
        return ChatMessage.builder()
                .sender(sender)
                .senderEmail(senderEmail)
                .message(message)
                .build();
    }
}
