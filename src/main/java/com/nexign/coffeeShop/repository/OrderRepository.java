package com.nexign.coffeeShop.repository;

import com.nexign.coffeeShop.domain.order.Order;

public interface OrderRepository {
    void save(Order order);
}
