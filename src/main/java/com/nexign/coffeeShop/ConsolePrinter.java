package com.nexign.coffeeShop;

public class ConsolePrinter implements PrintService {
    @Override
    public void print(Order order) {
        System.out.println("Items:");

        for (OrderItem item : order.getOrderItems()) {
            System.out.println("- " + item);
        }
        System.out.println("Total Price: " + order.getTotalPrice());
    }
}
