package com.ecommerce.ecommerce_backend.service.impl;

import com.ecommerce.ecommerce_backend.entity.*;
import com.ecommerce.ecommerce_backend.repository.CartRepository;
import com.ecommerce.ecommerce_backend.repository.OrderRepository;
import com.ecommerce.ecommerce_backend.repository.PaymentRepository;
import com.ecommerce.ecommerce_backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce_backend.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CartRepository cartRepo;
    @Autowired private OrderRepository orderRepo;
    @Autowired private PaymentRepository paymentRepo;

    @Override
    public String placeOrder(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepo.findByUser(user);

        Order order = new Order();
        order.setUser(user);
        order.setStatus("PLACED");

        double total = 0;
        List<OrderItem> items = new ArrayList<>();

        for (CartItem c : cart.getItems()) {

            OrderItem item = new OrderItem();
            item.setProduct(c.getProduct());
            item.setQuantity(c.getQuantity());
            item.setPrice(c.getProduct().getPrice());
            item.setOrder(order);

            total += item.getPrice() * item.getQuantity();

            items.add(item);
        }

        order.setItems(items);
        order.setTotalPrice(total);

        orderRepo.save(order);

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setStatus("SUCCESS");

        paymentRepo.save(payment);

        return "Order placed successfully";
    }
}