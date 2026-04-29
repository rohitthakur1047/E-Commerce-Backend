package com.ecommerce.ecommerce_backend.service.impl;

import com.ecommerce.ecommerce_backend.entity.Category;
import com.ecommerce.ecommerce_backend.repository.CategoryRepository;
import com.ecommerce.ecommerce_backend.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }
}