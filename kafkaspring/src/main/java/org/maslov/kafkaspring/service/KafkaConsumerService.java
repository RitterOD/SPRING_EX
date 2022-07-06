package org.maslov.kafkaspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.maslov.kafkaspring.configuration.AppConstant;
import org.maslov.kafkaspring.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static org.maslov.kafkaspring.configuration.AppConstant.CUSTOM_TIMESTAMP_HEADER;

@Service
@Slf4j
public class KafkaConsumerService {

    private final ObjectMapper objectMapper;




    public KafkaConsumerService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics={AppConstant.TOPIC_NAME})
    public void listen(Message message,
                       @Header(CUSTOM_TIMESTAMP_HEADER) String ts, @Header(KafkaHeaders.OFFSET) String offsetHeader) {
        try {
            String tmp = objectMapper.writeValueAsString(message);
            log.info("offset header:" + offsetHeader);
            log.info("Receive message: " + tmp);
            log.info(CUSTOM_TIMESTAMP_HEADER + ": " + ts);
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
        }

    }
}
