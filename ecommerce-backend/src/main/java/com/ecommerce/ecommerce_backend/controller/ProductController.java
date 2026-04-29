package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.dto.ProductRequest;
import com.ecommerce.ecommerce_backend.dto.ProductResponse;
import com.ecommerce.ecommerce_backend.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ GET ALL PRODUCTS
    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam int page,
            @RequestParam int size) {
        return productService.getAllProducts(page, size);
    }

    // ✅ ADD PRODUCT (ADMIN)
    @PostMapping("/admin")
    public ProductResponse addProduct(@RequestBody ProductRequest req) {
        return productService.addProduct(req);
    }
}