package com.nexign.coffeeShop.domain;

import com.nexign.coffeeShop.domain.decorator.Goodies;
import com.nexign.coffeeShop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private ProductRepository repository;
    private List<OrderItemBase> items = new ArrayList<>();

    public OrderBuilder(ProductRepository repository) {
        this.repository = repository;
    }

    public OrderBuilder addItem(String productName, int quantity) {
        Product product = repository.findByName(productName);
        items.add(new OrderItem(product, quantity));
        return this;
    }

    public OrderBuilder addDrink(String productName, CupSize cupSize, int quantity) {
        Product product = repository.findByName(productName);
        items.add(new SizedOrderItem(product, quantity, cupSize));
        return this;
    }

    public OrderBuilder addDrink(String productName, CupSize cupSize, Goodies...goodies) {
        Product product = repository.findByName(productName);
        for (Goodies goody : goodies) {
            goody.setCoffee(product);
            product = goody;
        }
        items.add(new SizedOrderItem(product, 1, cupSize));
        return this;
    }

    public Order build() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Empty order!");
        }
        return new Order(items);
    }
}
