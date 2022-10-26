package org.maslov.htmx.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.maslov.htmx.app.model.Message;
import org.maslov.htmx.app.model.mapper.MessageMapper;
import org.maslov.htmx.app.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class AppController {

    private final MessageService messageService;

    private final MessageMapper messageMapper;


    public AppController(MessageService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @GetMapping("/")
    ModelAndView getIndex() {
        var msgs = messageService.findAll();
        var views = messageMapper.map(msgs);
        return new ModelAndView("index", Map.of("messagesView", views));
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String search_pattern) {
        log.info("IN SEARCH");
        List<Message> msgs = messageService.findByMessageContaining(search_pattern);
        var views = messageMapper.map(msgs);
        return new ModelAndView("fragments/search :: search-result", Map.of("messagesView", views));
    }
}
