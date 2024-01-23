package com.hacker.hl.project.controller;

import com.hacker.hl.project.db.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChatMessage greeting(ChatMessage chat) throws Exception {
        Thread.sleep(1000); // simulated delay
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage(chat.getMessage());
        return chatMessage;
    }
}