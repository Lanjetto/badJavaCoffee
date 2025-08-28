package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.domain.models.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findByName(String name);
}
