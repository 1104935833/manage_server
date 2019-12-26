package org.sang.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * WebSocket 消息处理类
 * Created by sang on 2018/1/27.
 */
@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/ws/nf")
    @SendTo("/topic/nf")
    public String handleNF() {
        return "系统消息";
    }
}