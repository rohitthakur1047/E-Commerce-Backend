package com.ecommerce.ecommerce_backend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}