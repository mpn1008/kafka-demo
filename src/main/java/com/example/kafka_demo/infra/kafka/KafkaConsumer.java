package com.example.kafka_demo.infra.kafka;

import com.example.payment.PaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

  private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "#{kafkaConfig.paymentEventTopicId}")
  public void onBuyerCreatedEvent(
      PaymentEvent event,
      Acknowledgment acknowledgment) {
    log.info("method=onBuyerCreatedEvent, eventId={}", event.getEventId());
    acknowledgment.acknowledge();
  }
}
