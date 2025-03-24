package com.example.kafka_demo.app.cart;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class DeleteProductCartCmd {

  @NotNull
  private Long productId;
}