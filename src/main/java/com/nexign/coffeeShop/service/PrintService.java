package com.nexign.coffeeShop.service;

import java.io.PrintStream;

public class PrintService {
    public void printReceipt(PrintStream out) {
        out.println("Customer Name: " + customerName);
        out.println("Items:");

        for (String item : items) {
            out.println("- " + item);
        }

        out.println("Total Price: " + calculateTotalPrice());
    }
}
