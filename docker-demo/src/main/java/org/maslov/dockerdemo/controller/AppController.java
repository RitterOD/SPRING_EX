package org.maslov.dockerdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.maslov.dockerdemo.model.TodoItem;
import org.maslov.dockerdemo.model.TodoItemDTO;
import org.maslov.dockerdemo.service.TodoItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Slf4j
public class AppController {

    private final TodoItemService todoItemService;

    public AppController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/")
    public ModelAndView getMainPage() {
        log.info("Log in main");
        TodoItemDTO dto = new TodoItemDTO();
        var items = todoItemService.findAll();
        var mv = new ModelAndView("home", Map.of("items", items, "dto", dto));
        log.info("ModelV: " + mv);
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView processAdd(@ModelAttribute("dto") TodoItemDTO dto) {
        var item = new TodoItem();
        item.setText(dto.getText());
        todoItemService.save(item);
        dto = new TodoItemDTO();
        return new ModelAndView("home", Map.of("items", todoItemService.findAll(), "dto", dto));
    }

}
