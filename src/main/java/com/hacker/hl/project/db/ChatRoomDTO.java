package com.hacker.hl.project.db;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatRoomDTO {

    private String roomId;
    private String name;

    public ChatRoomDTO create(String name) {
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
