package com.nexign.coffeeShop.domain.order;

import com.nexign.coffeeShop.domain.models.Product;

public abstract class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public  abstract  double getTotalPrice();

    @Override
    public String toString() {
        return "product=" + product +
               ", quantity=" + quantity;
    }
}
