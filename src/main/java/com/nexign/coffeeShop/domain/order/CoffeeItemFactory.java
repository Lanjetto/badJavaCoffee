package com.nexign.coffeeShop.domain.order;

import com.nexign.coffeeShop.domain.DTO.OrderItemRequest;
import com.nexign.coffeeShop.domain.models.CupSize;
import com.nexign.coffeeShop.domain.models.Product;

public class CoffeeItemFactory implements OrderItemFactory {
    @Override
    public OrderItem createOrderItem(Product product, OrderItemRequest orderItemRequest) {
        return new SizedOrderItem(product, CupSize.valueOf(orderItemRequest.getSize()), orderItemRequest.getQuantity());
    }
}
