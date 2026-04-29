package com.ecommerce.ecommerce_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
    private double price;
}