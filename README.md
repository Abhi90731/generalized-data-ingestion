# Generalized Data Ingestion Service

This project is a Spring Boot-based backend service for ingesting log data via Apache Kafka and storing it into a ClickHouse database. It is designed to be scalable and easily adaptable to multiple data sources and sinks.

---

## Features

* **Kafka Integration:** Listens to a Kafka topic for incoming log events.
* **ClickHouse Integration:** Stores parsed log data into a ClickHouse table.
* **Spring Boot:** Easily extensible and modular architecture.
* **Test Support:** Embedded Kafka support for integration testing.

---

## Project Structure

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/example/ingestion/
│   │   │   ├── config/              # Kafka and DataSource configurations
│   │   │   ├── controller/          # REST controllers (if any)
│   │   │   ├── listener/            # Kafka consumers
│   │   │   ├── model/               # Data models
│   │   │   ├── service/             # ClickHouse services
│   │   │   └── IngestionApplication.java  # Main Spring Boot class
│   │   └── resources/
│   │       └── application.yml      # Production configuration
│   ├── test/
│   │   ├── java/com/example/ingestion/
│   │   │   └── IngestionApplicationTests.java  # Embedded Kafka test
│   │   └── resources/
│   │       └── application.properties  # Test-only configuration
├── build.gradle
└── README.md
```

---

## Requirements

* Java 17+
* Gradle
* Docker (for running Kafka and ClickHouse locally)

---

## Running the Application

1. **Start Dependencies** (via Docker):

```bash
docker-compose up -d
```

Ensure Kafka is accessible at `kafka:9092` and ClickHouse at `clickhouse:8123`.

2. **Build and Run:**

```bash
./gradlew clean build
./gradlew bootRun
```

---

## Running Tests

Tests use an embedded Kafka broker.

```bash
./gradlew test
```

Ensure you have this in `src/test/resources/application.properties`:

```properties
spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}
```

---

## Configuration

### application.yml (Production)

```yaml
server:
  port: 8080

spring:
  kafka:
    bootstrap-servers: kafka:9092
    consumer:
      group-id: log-consumer-group
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer

  datasource:
    url: jdbc:clickhouse://clickhouse:8123/default
    username: default
    password:
    driver-class-name: ru.yandex.clickhouse.ClickHouseDriver
```

---

## License

This project is licensed under the MIT License.
