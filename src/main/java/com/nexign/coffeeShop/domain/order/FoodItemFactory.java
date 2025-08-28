package com.nexign.coffeeShop.domain.order;

import com.nexign.coffeeShop.domain.DTO.OrderItemRequest;
import com.nexign.coffeeShop.domain.models.Product;

public class FoodItemFactory implements OrderItemFactory {
    @Override
    public OrderItem createOrderItem(Product product, OrderItemRequest orderItemRequest) {
        return new SimpleOrderItem(product, orderItemRequest.getQuantity());
    }
}
