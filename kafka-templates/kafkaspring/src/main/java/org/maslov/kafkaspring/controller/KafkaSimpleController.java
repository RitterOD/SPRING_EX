package org.maslov.kafkaspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.maslov.kafkaspring.model.Message;
import org.maslov.kafkaspring.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class KafkaSimpleController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaSimpleController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/api/message")
    public void post(@RequestBody Message message) {
        kafkaProducerService.sendMessage(message);
    }


}
