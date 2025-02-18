package com.nexign.coffeeShop.domain;

import java.io.PrintStream;

public class SpecialCoffeeOrder {

    public double calculateTotalPrice() {
        throw new IllegalArgumentException("Nexign is not allowed to order special orders");
    }


    public void printReceipt(PrintStream out) {
        System.out.println("There is no receipt for special orders");
    }


}
