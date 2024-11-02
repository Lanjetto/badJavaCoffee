package com.nexign.coffeeShop;

import java.io.PrintStream;

public class SpecialCoffeeOrder implements Order{
    @Override
    public double calculateTotalPrice() {
        throw new IllegalArgumentException("Nexign is not allowed to order special orders");
    }

    @Override
    public void printReceipt(PrintStream out) {
        System.out.println("There is no receipt for special orders");
    }


}
