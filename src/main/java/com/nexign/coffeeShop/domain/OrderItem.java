package com.nexign.coffeeShop.domain;

public record OrderItem(Product product, int quantity) implements OrderItemBase {
}
