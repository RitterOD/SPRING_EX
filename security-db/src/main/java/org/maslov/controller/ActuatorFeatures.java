package org.maslov.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.maslov.model.Message;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "messages")
public class ActuatorFeatures {
    private final Map<String, Message> messages = new ConcurrentHashMap<>();


    @ReadOperation
    public Map<String, Message> all() throws JsonProcessingException {
        return messages;
    }

    @ReadOperation
    public Message message(@Selector String name) throws JsonProcessingException {
        return messages.get(name);
    }

    @WriteOperation
    public Message configureMessage(@Selector String header, String author, String text) throws JsonProcessingException {
        Message msg = new Message(author, text);
        messages.put(header, msg);
        return msg;
    }

    @DeleteOperation
    public Message deleteMessage(@Selector String name) {
        return messages.remove(name);
    }
}
