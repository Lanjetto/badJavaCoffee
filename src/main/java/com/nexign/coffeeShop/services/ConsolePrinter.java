package com.nexign.coffeeShop.services;

import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.domain.order.OrderItem;

public class ConsolePrinter implements PrintService {
    @Override
    public void print(Order order) {
        System.out.println("Items:");

        for (OrderItem item : order.getOrderItems()) {
            System.out.println("- " + item);
        }
        System.out.println("Total Price: " + order.calculateTotalPrice());
    }
}
