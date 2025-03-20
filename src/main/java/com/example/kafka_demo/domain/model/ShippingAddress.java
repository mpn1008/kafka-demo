package com.example.kafka_demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Embeddable
@Accessors(chain = true)
@Getter
@Setter
public class ShippingAddress {
  @Column(name = "shipping_name", nullable = false)
  private String name;

  @Column(name = "shipping_phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "shipping_region", nullable = false)
  private String region;

  @Column(name = "shipping_street", nullable = false)
  private String street;
}