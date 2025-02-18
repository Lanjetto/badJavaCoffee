package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.domain.Coffee;
import com.nexign.coffeeShop.domain.CoffeeShop;
import com.nexign.coffeeShop.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCoffeeRepository implements ProductRepository {
    private Map<String, Double> coffeeMap = new HashMap<>();

    public InMemoryCoffeeRepository() {
        coffeeMap.put("cappuccino", 100.0);
        coffeeMap.put("latte", 120.0);
        coffeeMap.put("espresso", 80.0);
    }

    @Override
    public Optional<Double> findPriceByName(String productName) {
        return Optional.ofNullable(coffeeMap.get(productName));
    }

    @Override
    public Product findByName(String name) {
        Double price = findPriceByName(name).orElseThrow();
        return new Coffee(name, price);
    }
}
