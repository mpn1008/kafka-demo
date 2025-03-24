package com.example.kafka_demo.app.cart;

public interface BuyerShoppingCartService {
    Long createCart(CreateCartCmd cmd);

    void addProductCart(AddProductToCartCmd cmd);

    void updateProductCart(UpdateProductCartCmd cmd);

    void deleteProductCart(DeleteProductCartCmd cmd);

}
