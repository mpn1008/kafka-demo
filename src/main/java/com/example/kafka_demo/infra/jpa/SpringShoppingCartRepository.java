package com.example.kafka_demo.infra.jpa;

import com.example.kafka_demo.domain.model.ShoppingCart;
import com.example.kafka_demo.domain.model.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

  Optional<ShoppingCart> findByBuyerIdAndStatus(Long buyerID, ShoppingCartStatus status);
}
