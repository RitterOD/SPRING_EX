package org.maslov.dtapp.app.controller;


import org.maslov.dtapp.app.model.Message;
import org.maslov.dtapp.app.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppRestController {

    private final MessageService messageService;

    public AppRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok().body("Hello from Spring Boot3 Java17 Docker containerized application !");
    }

    @GetMapping("/messages/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok().body(messageService.findAll());
    }
}
