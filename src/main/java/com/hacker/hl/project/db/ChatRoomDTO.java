package com.hacker.hl.project.db;

import com.hacker.hl.project.db.entity.ChatRoom;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class ChatRoomDTO {

    private String name;

    public ChatRoom toEntity(String name) {
        return ChatRoom.builder()
                .name(name)
                .build();
    }
}
