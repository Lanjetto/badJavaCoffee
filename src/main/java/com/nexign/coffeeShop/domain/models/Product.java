package com.nexign.coffeeShop.domain.models;

public class Product {
    private Long id;
    private String name;
    private double price;
    private String type;

    public Product(Long id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + '\'' +
               ", base price=" + price;
    }
}
