package com.example.kafka_demo.domain.model;

import com.example.kafka_demo.app.common.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode(of = "shoppingCartId")
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

  @Id
  @Column(name = "shopping_cart_id", unique = true, nullable = false)
  @Setter(AccessLevel.NONE)
  private Long shoppingCartId = Long.sum(800_000_000L, IdGenerator.generate(0L, 99_999_999L));

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "shoppingCart")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Set<ShoppingCartItem> items = new HashSet<>();

  @Column(name = "buyer_id")
  private Long buyerId;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private ShoppingCartStatus status;

  @Setter(AccessLevel.NONE)
  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt = OffsetDateTime.now();

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;

  @OneToOne(cascade = CascadeType.ALL,
      mappedBy = "cart",
      orphanRemoval = true)
  @JsonIgnore
  private Order order;

  public BigDecimal getSubTotal() {
    return items
        .stream()
        .map(ShoppingCartItem::getSubTotal)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}