package com.crawler.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.crawler.ws.server.SpringWSServer;

@Configuration
@EnableWebSocket
public class WsConfigure implements WebSocketConfigurer {

	@Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
    {
        System.out.println("==========================");
        registry.addHandler(myHandler(), "/wsserver").setAllowedOrigins("*");
    }

    @Bean
    public SpringWSServer myHandler()
    {
        return new SpringWSServer();
    }

}
