package com.nexign.coffeeShop;


public class PaymentProcessor {
    public boolean processPayment(String paymentMethod) {
        if (paymentMethod.equals("Card")) {
            System.out.println("Processing credit card payment...");
            return true;
        } else if (paymentMethod.equals("Cash")) {
            System.out.println("Counting cash...");
            return true;
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
        }
    }
}