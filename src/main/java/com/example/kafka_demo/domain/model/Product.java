package com.example.kafka_demo.domain.model;

import com.example.kafka_demo.app.common.IdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode(of = "productId")
@ToString
@Entity
@Table(name = "product")
public class Product {

  @Id
  @Column(name = "product_id", unique = true, nullable = false)
  @Setter(AccessLevel.NONE)
  private Long productId = Long.sum(100_000_000L, IdGenerator.generate(0L, 99_999_999L));

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "product_price", nullable = false)
  private BigDecimal productPrice = new BigDecimal(0);

  @Column(name = "product_brand", nullable = false)
  private String productBrand;

  @Column(name = "product_colour", nullable = false)
  private String productColour;

  @Setter(AccessLevel.NONE)
  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt = OffsetDateTime.now();

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;

  @Column(name = "created_by", nullable = false, updatable = false)
  @CreatedBy
  private String createdBy;

  @Column(name = "updated_by", nullable = false)
  @LastModifiedBy
  private String updatedBy;
}