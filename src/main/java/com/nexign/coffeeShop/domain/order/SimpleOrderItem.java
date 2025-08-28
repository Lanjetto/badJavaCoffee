package com.nexign.coffeeShop.domain.order;

import com.nexign.coffeeShop.domain.models.Product;

public class SimpleOrderItem extends OrderItem {

    public SimpleOrderItem(Product product, int quantity) {
        super(product, quantity);
    }

    @Override
    public double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }
}
