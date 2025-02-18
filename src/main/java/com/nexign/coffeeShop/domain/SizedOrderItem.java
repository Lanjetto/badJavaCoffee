package com.nexign.coffeeShop.domain;

public class SizedOrderItem implements OrderItemBase {
    private Product product;
    private int quantity;
    private CupSize cupSize;

    public SizedOrderItem(Product product, int quantity, CupSize cupSize) {
        this.product = product;
        this.quantity = quantity;
        this.cupSize = cupSize;
    }

    public CupSize cupSize() {
        return cupSize;
    }

    @Override
    public Product product() {
        return product;
    }

    @Override
    public int quantity() {
        return quantity;
    }
}
