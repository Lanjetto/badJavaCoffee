package com.nexign.coffeeShop.services;

import com.nexign.coffeeShop.domain.Order;
import com.nexign.coffeeShop.domain.OrderItem;
import com.nexign.coffeeShop.domain.OrderItemBase;

public class ConsolePrinter implements PrintService {
    @Override
    public void print(Order order) {
        System.out.println("Items:");

        for (OrderItemBase item : order.getOrderItems()) {
            System.out.println("- " + item);
        }
        System.out.println("Total Price: " + order.getTotalPrice());
    }
}
