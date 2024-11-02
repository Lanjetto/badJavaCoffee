package com.nexign.coffeeShop;

import java.io.PrintStream;

public interface Order {
    double calculateTotalPrice();
    void printReceipt(PrintStream out);
}
