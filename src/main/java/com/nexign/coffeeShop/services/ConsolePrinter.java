package com.nexign.coffeeShop.services;

import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.domain.order.OrderItem;

public class ConsolePrinter implements PrintService {
    @Override
    public String print(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Items:\n");

        for (OrderItem item : order.getOrderItems()) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Total Price: ").append(order.calculateTotalPrice());
        sb.append("\n").append("--------------------------");
        return sb.toString();
    }
}
