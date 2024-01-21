package com.hacker.hl.project.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {


    private final WebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        /**
         * endpoint 설정 : /api/v1/chat/{postId}
         * ws://localhost:9090/ws/chat 으로 요청이 들어오면 websocket 통신을 진행
         * setAllowedOrigins("*")는 모든 ip에서 접속 가능하도록 해준다. -> 모든 CORS 요청을 허용
         * HTTP 80포트를 사용
         */
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }

}
