package com.example.test.repository;

import com.example.test.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed
}