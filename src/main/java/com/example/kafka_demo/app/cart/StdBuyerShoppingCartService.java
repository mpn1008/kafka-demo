package com.example.kafka_demo.app.cart;

import com.example.kafka_demo.domain.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class StdBuyerShoppingCartService implements BuyerShoppingCartService {
//  private final ProductRepository productRepository;

  private final ShoppingCartRepository shoppingCartRepository;

  @Override
  public Long createCart(CreateCartCmd cmd) {
    return 0L;
  }

  @Override
  public void addProductCart(AddProductToCartCmd cmd) {
  }

  @Override
  public void updateProductCart(UpdateProductCartCmd cmd) {

  }

  @Override
  public void deleteProductCart(DeleteProductCartCmd cmd) {

  }
}
