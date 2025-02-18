package com.nexign.coffeeShop;

public class CardPayment implements PaymentService{
    @Override
    public boolean processPayment() {
        System.out.println("Card");
        return true;
    }
}
