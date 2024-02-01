package com.hacker.hl.project.controller;

import com.hacker.hl.project.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage processMessage(ChatMessage message) {
        // 발신자 정보를 포함한 메시지 처리
        return message;
    }
}


