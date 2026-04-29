package com.ecommerce.ecommerce_backend.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int stock;

    @ManyToOne
    private Category category;
}