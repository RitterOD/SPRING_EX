package org.maslov.dtapp.app.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.dtapp.app.model.Message;
import org.maslov.dtapp.app.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
