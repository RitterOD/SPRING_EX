package org.maslov.websoketdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.maslov.websoketdemo.model.ChatMessage;
import org.maslov.websoketdemo.model.OutputChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputChatMessage send(ChatMessage message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputChatMessage(message.getFrom(), message.getText(), time);
    }
}
