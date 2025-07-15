package com.example.ingestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ClickHouseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLog(String message) {
        String sql = "INSERT INTO logs (timestamp, level, message, metadata) VALUES (?, ?, ?, ?)";
        Timestamp now = new Timestamp(System.currentTimeMillis());

        // For demo, let’s store the whole message as `message` and dummy values for level/metadata
        jdbcTemplate.update(sql, now, "INFO", message, "{}");
    }
}
