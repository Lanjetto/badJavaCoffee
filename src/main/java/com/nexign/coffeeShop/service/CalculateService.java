package com.nexign.coffeeShop.service;

import com.nexign.coffeeShop.Order;

import java.util.List;

public class CalculateService {

    public double calculateTotalPrice(List<Order> orders)  {

        double totalPrice = 0.0;

        for (Order order : orders) {
            switch (order) {
                case "Espresso" -> totalPrice += 100;
                case "Cappuccino" -> totalPrice += 150;
                case "Latte" -> totalPrice += 120;
                default -> throw new IllegalArgumentException("Unknown item: " + item);
            }
        }

        return totalPrice;
    }
}
