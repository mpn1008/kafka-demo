package com.example.kafka_demo.domain.repository;

import com.example.kafka_demo.domain.model.ShoppingCart;
import com.example.kafka_demo.domain.model.ShoppingCartStatus;

import java.util.Optional;

public interface ShoppingCartRepository {
  ShoppingCart requireById(Long cartId) throws InterruptedException;

  Optional<ShoppingCart> findByBuyerIdAndStatus(Long buyerId, ShoppingCartStatus status);

  ShoppingCart requireCurrentCart(Long buyerId);

  /**
   * Saves the account to the persistence store.
   *
   * @param account the account to save
   */
  void create(ShoppingCart account);

  /**
   * Finds the account given the wallet id.
   *
   * @param cartId the wallet id to find
   * @return the account if found
   */
  Optional<ShoppingCart> findById(Long cartId);
}
