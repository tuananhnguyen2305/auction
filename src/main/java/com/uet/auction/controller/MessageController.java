package com.uet.auction.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public String newMsg(@Payload String msg) {
        return msg;
    }
}
