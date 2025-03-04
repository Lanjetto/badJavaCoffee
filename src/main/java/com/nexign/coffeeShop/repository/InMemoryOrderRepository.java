package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.domain.order.Order;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOrderRepository implements OrderRepository {
    private Map<Long, Order> orders = new HashMap<>();
    private long nextId = 1;

    @Override
    public void save(Order order) {
        orders.put(nextId++, order);
    }
}
