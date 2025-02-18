package com.nexign.coffeeShop.domain;


import java.time.LocalDateTime;
import java.util.List;

//добавить копию в список
public class Order {
    private List<OrderItemBase> orderItems;
    private LocalDateTime timeStamp = LocalDateTime.now();
    private double totalPrice;

    public Order(List<OrderItemBase> orderItems) {
        this.orderItems = orderItems;
        this.totalPrice = calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double calculateTotalPrice() {
        return orderItems.stream()
                .mapToDouble(x -> x.product().getPrice() * x.quantity())
                .sum();
    }

    public List<OrderItemBase> getOrderItems() {
        return orderItems;
    }
}
