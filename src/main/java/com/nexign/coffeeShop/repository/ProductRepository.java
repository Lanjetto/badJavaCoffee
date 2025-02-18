package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.domain.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Double> findPriceByName(String productName);
    Product findByName(String name);
}
