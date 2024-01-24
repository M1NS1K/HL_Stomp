package com.hacker.hl.project.controller;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stomp")
@RequiredArgsConstructor
public class StompController {

    // 간단한 메시징 프로토콜(예: STOMP)에 사용하기 위한 메서드가 포함된 MessageSendingOperations의 구현체
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    /**
     * /topic/wiki로 데이터를 publish한다.
     */
    @GetMapping("/topic")
    @ResponseBody
    public String publishTopicMessage() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");

        simpMessageSendingOperations.convertAndSend("/topic/wiki", data);

        return "OK";
    }
}
