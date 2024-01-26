package com.hacker.hl.project.repository;

import com.hacker.hl.project.db.ChatRoomDTO;
import com.hacker.hl.project.db.entity.ChatRoom;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatRoomRepository {

    private final ChatRoomDTO chatRoomDTO;
    private Map<String, ChatRoom> chatRoomDTOMap;

    @PostConstruct
    private void init() {
        chatRoomDTOMap = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRooms() {
        List<ChatRoom> result = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(result);

        return result;
    }

    public ChatRoom findRoomById(String id){
        return chatRoomDTOMap.get(id);
    }

    public ChatRoom createChatRoomDTO(String name){
        ChatRoom room = chatRoomDTO.toEntity(name);
        chatRoomDTOMap.put(room.getName(), room);

        return room;
    }
}
