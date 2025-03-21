package com.example.kafka_demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode(of = "addressId")
@Entity
@Table(name = "buyer_address")
public class Address {

  @Id
  @Column(name = "address_id", updatable = false, nullable = false)
  @Setter(AccessLevel.NONE)
  private UUID addressId = UUID.randomUUID();

  @Column(name = "buyer_id", updatable = false, nullable = false)
  private Long buyerId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "default_address", nullable = false)
  private Boolean defaultAddress;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "region", nullable = false)
  private String region;

  @Column(name = "street", nullable = false)
  private String street;

  @Setter(AccessLevel.NONE)
  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt = OffsetDateTime.now();

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;
}
