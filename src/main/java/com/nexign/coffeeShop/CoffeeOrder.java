package com.nexign.coffeeShop;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder implements Order{
    private String customerName;
    private List<String> items = new ArrayList<>();


    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public double calculateTotalPrice() {

        double totalPrice = 0.0;

        for (String item : items) {
            switch (item) {
                case "Espresso" -> totalPrice += 100;
                case "Cappuccino" -> totalPrice += 150;
                case "Latte" -> totalPrice += 120;
                default -> throw new IllegalArgumentException("Unknown item: " + item);
            }
        }

        return totalPrice;
    }

    @Override
    public void printReceipt(PrintStream out) {
        out.println("Customer Name: " + customerName);
        out.println("Items:");

        for (String item : items) {
            out.println("- " + item);
        }

        out.println("Total Price: " + calculateTotalPrice());
    }
}
