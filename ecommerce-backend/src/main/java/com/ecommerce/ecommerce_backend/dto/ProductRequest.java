package com.ecommerce.ecommerce_backend.dto;

import lombok.*;

@Getter @Setter
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private int stock;
    private Long categoryId;
}