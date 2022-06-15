package org.maslov.dockerdemo.service;


import org.maslov.dockerdemo.model.TodoItem;
import org.maslov.dockerdemo.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {

    private final TodoItemRepository todoItemRepository;


    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> findAll() {
        return todoItemRepository.findAll();
    }

    public TodoItem save(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }
}
