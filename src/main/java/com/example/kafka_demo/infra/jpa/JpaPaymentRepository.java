package com.example.kafka_demo.infra.jpa;

import com.example.kafka_demo.domain.model.ShoppingCart;
import com.example.kafka_demo.domain.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@AllArgsConstructor
public class JpaPaymentRepository implements ShoppingCartRepository {

  private final SpringShoppingCartRepository repository;

  @Override
  public ShoppingCart requireById(Long cartId) {
    var cart = repository.findById(cartId)
        .orElseThrow(() -> new RuntimeException("Error"));

    log.info("method: requireById, cartId: {} , cart: {}", cartId, cart);

    return cart;
  }
}
