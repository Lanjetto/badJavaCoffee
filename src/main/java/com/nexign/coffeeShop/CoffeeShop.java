package com.nexign.coffeeShop;

public class CoffeeShop {

    public void createOrder(Order order, PaymentService paymentService, PrintService printService) {
        paymentService.processPayment();
        printService.print(order);
    }
}