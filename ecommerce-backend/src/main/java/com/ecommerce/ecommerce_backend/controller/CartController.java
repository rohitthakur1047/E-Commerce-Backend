package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.entity.Cart;
import com.ecommerce.ecommerce_backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long userId,
                            @RequestParam Long productId,
                            @RequestParam int qty) {
        return cartService.addToCart(userId, productId, qty);
    }

    @GetMapping
    public Cart getCart(@RequestParam Long userId) {
        return cartService.getCart(userId);
    }
}