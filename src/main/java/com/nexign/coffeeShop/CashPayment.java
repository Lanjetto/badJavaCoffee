package com.nexign.coffeeShop;

public class CashPayment implements PaymentService{
    @Override
    public boolean processPayment() {
        System.out.println("Cash");
        return true;
    }
}
