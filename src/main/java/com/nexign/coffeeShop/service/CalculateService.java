package com.nexign.coffeeShop.service;

public class CalculateService {

    public double calculateTotalPrice(Order order)  {
        return order.getOrderItems().stream()
                .mapToDouble(x->x.product().price() * x.quantity())
                .sum();
    }
}
