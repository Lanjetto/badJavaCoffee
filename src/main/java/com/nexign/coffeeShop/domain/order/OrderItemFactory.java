package com.nexign.coffeeShop.domain.order;

import com.nexign.coffeeShop.domain.DTO.OrderItemRequest;
import com.nexign.coffeeShop.domain.models.Product;

public interface OrderItemFactory {
    OrderItem createOrderItem(Product product, OrderItemRequest orderItemRequest);
}
