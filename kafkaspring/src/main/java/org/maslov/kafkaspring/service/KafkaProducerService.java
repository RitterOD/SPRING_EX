package org.maslov.kafkaspring.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.maslov.kafkaspring.configuration.AppConstant;
import org.maslov.kafkaspring.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate kafkaTemplate;

    public KafkaProducerService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message) {
        ProducerRecord record = new ProducerRecord<String, Message>(AppConstant.TOPIC_NAME, message);
        record.headers().add(AppConstant.CUSTOM_TIMESTAMP_HEADER, ("" + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(record);

    }
}
