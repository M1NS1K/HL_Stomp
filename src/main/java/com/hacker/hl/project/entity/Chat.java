package com.hacker.hl.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private ChatRoom room;

    private String sender;

    private String senderEmail;

    @Column(columnDefinition = "TEXT")
    private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime sendDate;

    @Builder
    public Chat(ChatRoom room, String sender, String senderEmail, String message, LocalDateTime sendDate) {
        this.room = room;
        this.sender = sender;
        this.senderEmail = senderEmail;
        this.message = message;
        this.sendDate = sendDate;
    }

    public static Chat createChat(ChatRoom room, String sender, String senderEmail, String message) {
        return Chat.builder()
                .room(room)
                .sender(sender)
                .senderEmail(senderEmail)
                .message(message)
                .build();
    }
}