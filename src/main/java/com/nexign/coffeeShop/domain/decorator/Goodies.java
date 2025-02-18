package com.nexign.coffeeShop.domain.decorator;

import com.nexign.coffeeShop.domain.Coffee;
import com.nexign.coffeeShop.domain.Product;

public abstract class Goodies extends Product {
    private Product coffee;

    public Goodies(String name, double price) {
        super(name, price);
    }

    public Product getCoffee() {
        return coffee;
    }

    public void setCoffee(Product coffee) {
        this.coffee = coffee;
    }
}
