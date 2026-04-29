package com.ecommerce.ecommerce_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private String status; // SUCCESS / FAILED
}