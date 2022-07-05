package org.maslov.kafkaspring.controller;

import org.maslov.kafkaspring.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaSimpleController {

    private final KafkaTemplate kafkaTemplate;

    public KafkaSimpleController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/api/message")
    public void post(@RequestBody Message message) {
        kafkaTemplate.send("springTopic", message);
    }
}
