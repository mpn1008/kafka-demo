package com.example.kafka_demo.infra.jpa;

import com.example.kafka_demo.domain.model.ShoppingCart;
import com.example.kafka_demo.domain.model.ShoppingCartStatus;
import com.example.kafka_demo.domain.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

  @Override
  public Optional<ShoppingCart> findByBuyerIdAndStatus(Long buyerId, ShoppingCartStatus status) {
    return Optional.empty();
  }

  @Override
  public ShoppingCart requireCurrentCart(Long buyerId) {
    return null;
  }

  @Override
  public void create(ShoppingCart account) {
    repository.save(account);
  }

  @Override
  public Optional<ShoppingCart> findById(Long cartId) {
    return Optional.empty();
  }
}
