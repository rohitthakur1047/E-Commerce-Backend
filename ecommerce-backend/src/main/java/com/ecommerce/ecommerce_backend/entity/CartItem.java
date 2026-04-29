package com.ecommerce.ecommerce_backend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private int quantity;
}