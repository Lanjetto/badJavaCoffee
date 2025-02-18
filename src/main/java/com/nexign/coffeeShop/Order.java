package com.nexign.coffeeShop;


import java.time.LocalDateTime;
import java.util.List;

//добавить копию в список
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

    private double calculateTotalPrice() {
        return orderItems.stream()
                .mapToDouble(x -> x.product().getPrice() * x.quantity())
                .sum();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
