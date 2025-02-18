package com.nexign.coffeeShop;

import java.util.List;

public class App {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        CardPayment cardPayment = new CardPayment();

        Product p1 = new Product("cappuccino", 100.0);
        Product p2 = new Product("espresso", 80.0);

        OrderItem orderItem1 = new OrderItem(p1, 1);
        OrderItem orderItem2 = new OrderItem(p2, 2);

        Order order = new Order(List.of(orderItem1, orderItem2));
        coffeeShop.createOrder(order, cardPayment, consolePrinter);
    }
}
