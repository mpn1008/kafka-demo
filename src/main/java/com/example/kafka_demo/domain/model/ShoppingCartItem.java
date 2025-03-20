package com.example.kafka_demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode(of = "cartItemId")
@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {

  @Id
  @Column(name = "shopping_cart_item_id", unique = true, nullable = false)
  private UUID cartItemId = UUID.randomUUID();

  @JsonIgnore
  @ManyToOne(targetEntity = ShoppingCart.class)
  @JoinColumn(name = "shopping_cart_id", nullable = false)
  private ShoppingCart shoppingCart;

  @Column(name = "quantity")
  private Integer quantity = 1;

  @Column(name = "price")
  private BigDecimal price = BigDecimal.ZERO;

  @Column(name = "product_id", nullable = false)
  private Long productId;


  @JsonIgnore
  @Transient
  private Product product;

  public BigDecimal getSubTotal() {
    return price.multiply(BigDecimal.valueOf(quantity));
  }
}