package com.ecommerce.ecommerce_backend.services;

import com.ecommerce.ecommerce_backend.dto.ProductRequest;
import com.ecommerce.ecommerce_backend.dto.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponse addProduct(ProductRequest req);

    Page<ProductResponse> getAllProducts(int page, int size);  // ✅ UPDATED
}