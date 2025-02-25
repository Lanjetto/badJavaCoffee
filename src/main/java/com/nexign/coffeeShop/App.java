package com.nexign.coffeeShop;


import com.nexign.coffeeShop.domain.utils.JsonFileReader;
import com.nexign.coffeeShop.repository.InMemoryCoffeeRepository;
import com.nexign.coffeeShop.repository.InMemoryOrderRepository;
import com.nexign.coffeeShop.services.OrderService;
import com.nexign.coffeeShop.services.factories.PaymentServiceFactory;
import com.nexign.coffeeShop.services.factories.ReceiptServiceFactory;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            var orderRequest = JsonFileReader.readOrderRequest("request.json");
            var orderRepo = new InMemoryOrderRepository();

            var productRepo = new InMemoryCoffeeRepository();

            var order = new OrderService(productRepo, orderRepo).createOrder(orderRequest);
            var paymentService = PaymentServiceFactory.getPaymentService(orderRequest.getPaymentMethod());
            paymentService.processPayment();
            var receiptService = ReceiptServiceFactory.getReceiptService(orderRequest.getPaymentMethod());
            receiptService.print(order);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
