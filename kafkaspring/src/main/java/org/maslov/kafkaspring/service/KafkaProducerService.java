package org.maslov.kafkaspring.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.maslov.kafkaspring.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate kafkaTemplate;
    public final static String CUSTOM_TIMESTAMP_HEADER = "CUSTOM_TS";

    public KafkaProducerService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message) {
        ProducerRecord record = new ProducerRecord<String, Message>("springTopic", message);
        record.headers().add(CUSTOM_TIMESTAMP_HEADER, ("" + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(record);

    }
}
