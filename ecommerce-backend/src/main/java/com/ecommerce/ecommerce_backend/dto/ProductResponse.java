package com.ecommerce.ecommerce_backend.dto;


import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
}