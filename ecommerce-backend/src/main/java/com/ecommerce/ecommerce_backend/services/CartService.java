package com.ecommerce.ecommerce_backend.services;

import com.ecommerce.ecommerce_backend.entity.Cart;

public interface CartService {
    String addToCart(Long userId, Long productId, int quantity);
    Cart getCart(Long userId);
}