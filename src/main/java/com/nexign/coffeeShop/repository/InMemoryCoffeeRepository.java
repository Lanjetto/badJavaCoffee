package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.domain.models.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCoffeeRepository implements ProductRepository {
    private Map<Long, Product> coffeeMap = new HashMap<>();

    public InMemoryCoffeeRepository() {
        initialize();
    }

    private void initialize() {
        coffeeMap.put(1L, new Product(1L, "latte", 120.0, "COFFEE"));
        coffeeMap.put(2L, new Product(2L, "espresso", 80.0, "COFFEE"));
        coffeeMap.put(3L, new Product(3L,"cappuccino", 100.0, "COFFEE"));
        coffeeMap.put(4L, new Product(4L,"pie", 100.0, "FOOD"));
    }

    @Override
    public Optional<Product> findByName(String name) {
        return coffeeMap.values()
                .stream()
                .filter(coffee -> coffee.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
