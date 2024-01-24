package com.hacker.hl.project.db;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.springframework.web.socket.WebSocketSession;

public class ChatRoomDTO {

    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoomDTO create(String name) {
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
