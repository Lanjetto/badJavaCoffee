package com.nexign.coffeeShop.domain.order;


import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private List<OrderItem> orderItems;
    private LocalDateTime timeStamp = LocalDateTime.now();
    private double totalPrice;

    public Order(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        this.totalPrice = calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateTotalPrice() {
        return orderItems.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
