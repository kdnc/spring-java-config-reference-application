package com.nuwan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//@EnableWebSocketMessageBroker enables WebSocket message handling, backed by a message broker.
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * The configureMessageBroker() method overrides the default method in
     * WebSocketMessageBrokerConfigurer to configure the message broker.
     * @return
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // calling enableSimpleBroker() to enable a simple memory-based message broker
        // to carry the greeting messages back to the client on destinations prefixed with "/topic".
        config.enableSimpleBroker("/topic");
        // Designates the "/websocket-app" prefix for messages that are bound for @MessageMapping-annotated methods.
        config.setApplicationDestinationPrefixes("/websocket-app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // registers the "/websocket-app/hello" endpoint, enabling SockJS fallback options so that alternative
        // messaging options may be used if WebSocket is not available. This endpoint, when prefixed
        // with "/app", is the endpoint that the GreetingController.greeting() method is mapped to handle.
        stompEndpointRegistry.addEndpoint("/hello").withSockJS();
    }

}
