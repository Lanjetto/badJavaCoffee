package com.nexign.coffeeShop.domain;

import com.nexign.coffeeShop.services.PaymentService;
import com.nexign.coffeeShop.services.PrintService;

public class CoffeeShop {

    public void createOrder(Order order, PaymentService paymentService, PrintService printService) {
        paymentService.processPayment();
        printService.print(order);
    }
}