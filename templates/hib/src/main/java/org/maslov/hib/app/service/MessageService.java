package org.maslov.hib.app.service;

import lombok.extern.slf4j.Slf4j;


import org.maslov.hib.app.model.Message;
import org.maslov.hib.app.repository.MessageRepository;
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
