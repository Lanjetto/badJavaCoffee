package com.nexign.coffeeShop.services;

import com.nexign.coffeeShop.domain.DTO.OrderItemRequest;
import com.nexign.coffeeShop.domain.DTO.OrderRequest;
import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.domain.order.OrderItem;
import com.nexign.coffeeShop.repository.OrderRepository;
import com.nexign.coffeeShop.repository.ProductRepository;
import com.nexign.coffeeShop.domain.order.CoffeeItemFactory;
import com.nexign.coffeeShop.domain.order.FoodItemFactory;
import com.nexign.coffeeShop.domain.order.OrderItemFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private Map<String, OrderItemFactory> factoryMap = new HashMap<>();


    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        factoryMap.put("coffee", new CoffeeItemFactory());
        factoryMap.put("food", new FoodItemFactory());
    }

    public Order createOrder(OrderRequest request) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest orderItem : request.getOrderItems()) {
            var product = productRepository.findByName(orderItem.getProductName().toLowerCase())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found " + orderItem.getProductName()));

            var productType = product.getType().toLowerCase();
            var factory = factoryMap.getOrDefault(productType, new FoodItemFactory());

            var item = factory.createOrderItem(product, orderItem);

            orderItems.add(item);
        }

        var order = new Order(orderItems);
        orderRepository.save(order);

        return order;
    }

}
