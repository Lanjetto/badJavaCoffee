package com.nexign.coffeeShop.domain.order;

import com.nexign.coffeeShop.domain.models.CupSize;
import com.nexign.coffeeShop.domain.models.Product;

public class SizedOrderItem extends OrderItem {
    private CupSize size;

    public SizedOrderItem(Product product, CupSize size,int quantity) {
        super(product, quantity);
        this.size = size;
    }

    public CupSize getSize() {
        return size;
    }

    public void setSize(CupSize size) {
        this.size = size;
    }

    @Override
    public double getTotalPrice() {
        return getProduct().getPrice() *
               size.getModifier() *
               getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + " size=" + size + " price=" + getTotalPrice();
    }
}
