package com.example.ingestion.listener;

import com.example.ingestion.service.ClickHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LogEventListener {

    @Autowired
    private ClickHouseService clickHouseService;

    @KafkaListener(topics = "logs", groupId = "log-consumer-group")
    public void consume(String message) {
        System.out.println("Received message from Kafka: " + message);

        // Insert the message into ClickHouse
        clickHouseService.insertLog(message);
    }
}
