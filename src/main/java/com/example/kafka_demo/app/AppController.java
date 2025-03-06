package com.example.kafka_demo.app;

import com.example.kafka_demo.domain.EventRecord;
import com.example.kafka_demo.domain.service.EventService;
import com.example.payment.PaymentEvent;
import com.example.payment.PaymentEventKey;
import com.example.payment.PaymentMethod;
import com.example.payment.PaymentStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AppController {

  private final EventService svc;

  public AppController(EventService svc) {
    this.svc = svc;
  }

  @GetMapping("/hello-world")
  public String hello() {
    var key = PaymentEventKey.newBuilder()
        .setEventId("Key")
        .build();
    var event = PaymentEvent.newBuilder()
        .setEventId(UUID.randomUUID().toString())
        .setUserId(UUID.randomUUID().toString())
        .setAmount(1000000)
        .setTimestamp(179090937)
        .setPaymentMethod(PaymentMethod.BANK_TRANSFER)
        .setStatus(PaymentStatus.COMPLETED)
        .setCurrency("USD")
        .build();

    svc.send("payment-event", key, event);
    return "Hello world";
  }
}
