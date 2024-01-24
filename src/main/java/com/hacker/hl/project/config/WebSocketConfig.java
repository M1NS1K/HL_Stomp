package com.hacker.hl.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //웹 소켓 메시지를 다룰 수 있게 허용
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 클라이언트에서 websocket에 접속하는 endpoint를 등록한다.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*");
    }

    /**
     * Stomp사용을 위한 Message Broker 설정을 해주는 메소드
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/pub") // 메세지를 보낼(publish) 경로를 설정
                .setUserDestinationPrefix("/users")  // 특정 사용자에게 메시지 전송시 사용할 주소
                .enableStompBrokerRelay("/queue", "/topic", "/exchange") // 메세지 수신(Subscribe), 경로를 설정해주는 메서드
                .setRelayHost("localhost")
                .setVirtualHost("/")
                .setRelayPort(61613) // RabbitMQ STOMP 기본 포트
                .setSystemLogin("guest")
                .setSystemPasscode("guest")
                .setClientLogin("guest")
                .setClientPasscode("guest");
    }

}

