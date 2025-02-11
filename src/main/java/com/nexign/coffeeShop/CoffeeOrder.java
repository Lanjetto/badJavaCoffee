package com.nexign.coffeeShop;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder {
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


}
