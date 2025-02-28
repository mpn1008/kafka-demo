//package com.example.kafka_demo.infra.kafka;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Data
//@Configuration
//@ConfigurationProperties("kafkademo.infra.kafka")
//@Slf4j
//public class KafkaConfig {
//  private String topic;
//
//  @Bean
//  public KafkaTemplate<String, Object> kafkaTemplate() {
//    return new KafkaTemplate<String, Object>(producerFactory());
//  }
//}
