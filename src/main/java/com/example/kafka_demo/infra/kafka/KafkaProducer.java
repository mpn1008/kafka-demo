package com.example.kafka_demo.infra.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducer {
  private static final Logger log = LogManager.getLogger(KafkaProducer.class);
  private final KafkaTemplate<String, Object> kafkaTemplate;

  public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public boolean send(String topic, Object key, Object t) {
    try {
      this.kafkaTemplate.send(topic, t);
    } catch (Error e) {
      log.info("error={}", e.getMessage());
    }
    return true;
  }
}
