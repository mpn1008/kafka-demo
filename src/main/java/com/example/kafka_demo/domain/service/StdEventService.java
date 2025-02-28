package com.example.kafka_demo.domain.service;

import com.example.kafka_demo.infra.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class StdEventService implements EventService{

  private final KafkaProducer producer;

  public StdEventService(KafkaProducer producer) {
    this.producer = producer;
  }

  @Override
  public boolean send(String topic, Object record) {
    return producer.send(topic, record);
  }
}
