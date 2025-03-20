package com.example.kafka_demo.domain.model;

import com.example.kafka_demo.app.common.IdGenerator;
import com.example.payment.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode(of = "orderId")
@Entity
@NamedEntityGraph(
    name = "orderAggregate",
    attributeNodes = {
        @NamedAttributeNode("cart"),
    }
)
@Table(name = "shopping_order")
public class Order {

  @Id
  @Column(name = "order_id", unique = true, nullable = false)
  @Setter(AccessLevel.NONE)
  private Long orderId = Long.sum(700_000_000L, IdGenerator.generate(0L, 99_999_999L));

  @Column(name = "buyer_id")
  private Long buyerId;

  @OneToOne(optional = false)
  @JoinColumn(
      name = "cart_id",
      referencedColumnName = "shopping_cart_id",
      updatable = false,
      nullable = false
  )
  private ShoppingCart cart;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private OrderStatus status;

  @Enumerated(EnumType.STRING)
  @Column(name = "payment_method", nullable = false)
  private PaymentMethod paymentMethod;

  @Embedded
  private ShippingAddress shippingAddress;

  @Setter(AccessLevel.NONE)
  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt = OffsetDateTime.now();

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;
}