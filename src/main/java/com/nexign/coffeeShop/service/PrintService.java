package com.nexign.coffeeShop.service;

import java.io.PrintStream;

public class PrintService {
    public void printReceipt(PrintStream out, Order order) {
        out.println("Items:");

        for (String item : items) {
            out.println("- " + item);
        }

        out.println("Total Price: " + calculateTotalPrice());
    }
}
