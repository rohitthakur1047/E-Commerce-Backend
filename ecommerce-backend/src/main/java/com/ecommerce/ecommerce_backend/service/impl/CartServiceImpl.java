package com.ecommerce.ecommerce_backend.service.impl;

import com.ecommerce.ecommerce_backend.entity.Cart;
import com.ecommerce.ecommerce_backend.entity.CartItem;
import com.ecommerce.ecommerce_backend.entity.Product;
import com.ecommerce.ecommerce_backend.entity.User;
import com.ecommerce.ecommerce_backend.repository.CartRepository;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;
import com.ecommerce.ecommerce_backend.repository.UserRepository;
import com.ecommerce.ecommerce_backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepo;
    @Autowired private ProductRepository productRepo;
    @Autowired private UserRepository userRepo;

    @Override
    public String addToCart(Long userId, Long productId, int quantity) {

        User user = userRepo.findById(userId).orElseThrow();
        Product product = productRepo.findById(productId).orElseThrow();

        Cart cart = cartRepo.findByUser(user);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        cart.setItems(List.of(item));

        cartRepo.save(cart);
        return "Added to cart";
    }

    @Override
    public Cart getCart(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return cartRepo.findByUser(user);
    }
}