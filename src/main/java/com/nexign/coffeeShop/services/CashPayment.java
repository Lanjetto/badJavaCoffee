package com.nexign.coffeeShop.services;

public class CashPayment implements PaymentService{
    @Override
    public boolean processPayment() {
        System.out.println("Cash");
        return true;
    }
}
