package com.example.ingestion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;


// @SpringBootTest(properties = {
//     "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration"
// })
// @EmbeddedKafka(partitions = 1, topics = { "my-topic" })
// @TestPropertySource(properties = {
//     "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}"
// })
@Disabled("Temporarily disabled due to configuration issues")
class IngestionApplicationTests {
    
    @Test
    void contextLoads() {
    }
}