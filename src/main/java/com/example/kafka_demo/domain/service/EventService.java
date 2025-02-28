package com.example.kafka_demo.domain.service;

public interface EventService {
  boolean send(String topic, Object record);
}
