package com.example.ingestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingest")
public class IngestController {

    private static final String TOPIC = "logs";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/log")
    public String ingestLog(@RequestBody String payload) {
        kafkaTemplate.send(TOPIC, payload);
        return "Log sent to Kafka topic: " + TOPIC;
    }
}
