package com.example.kafka_demo.app.cart;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class CreateCartCmd {

  private Long buyerId;
}