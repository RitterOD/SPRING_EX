package org.maslov.kafkaspring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.maslov.kafkaspring.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class KafkaSimpleController {

    private final KafkaTemplate kafkaTemplate;

    private final ObjectMapper objectMapper;

    public KafkaSimpleController(KafkaTemplate kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/api/message")
    public void post(@RequestBody Message message) {
        kafkaTemplate.send("springTopic", message);
    }

    @KafkaListener(topics={"springTopic"})
    public void listen(Message message) {
        try {
            String tmp = objectMapper.writeValueAsString(message);
            log.info("Receive message: " + tmp);
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
        }

    }
}
