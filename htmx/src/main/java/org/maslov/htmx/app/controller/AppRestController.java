package org.maslov.htmx.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.maslov.htmx.app.model.Message;
import org.maslov.htmx.app.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AppRestController {

    private final MessageService messageService;

    public AppRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/clicked")
    public String clicked() {
        return "<h1> Random number from server: " + Math.random() + "</h1>";
    }

}
