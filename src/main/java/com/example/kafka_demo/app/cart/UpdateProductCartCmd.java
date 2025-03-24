package com.example.kafka_demo.app.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Data
public class UpdateProductCartCmd {

  @NotNull
  private UUID cartItemId;

  @Min(1)
  private Integer quantity;
}