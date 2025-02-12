package com.nexign.coffeeShop.service;

import com.nexign.coffeeShop.OrderItem;

import java.util.List;

public class Order {
    private List<OrderItem> orderItems;

    public Order(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {

        return orderItems;
    }
}
