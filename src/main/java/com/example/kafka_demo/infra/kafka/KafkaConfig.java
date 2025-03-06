package com.example.kafka_demo.infra.kafka;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties("kafkademo.infra.kafka")
@Slf4j
public class KafkaConfig {
  private String paymentEventTopicId = "payment-event";
}
