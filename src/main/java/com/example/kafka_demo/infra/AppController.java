package com.example.kafka_demo.infra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/hello-world")
  public String hello() {
    return "Hello world";
  }
}
