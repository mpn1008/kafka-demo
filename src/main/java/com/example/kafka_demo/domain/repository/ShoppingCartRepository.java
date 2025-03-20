package com.example.kafka_demo.domain.repository;

import com.example.kafka_demo.domain.model.ShoppingCart;

public interface ShoppingCartRepository {
  ShoppingCart requireById(Long cartId);
}
