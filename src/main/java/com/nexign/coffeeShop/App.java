package com.nexign.coffeeShop;


import com.nexign.coffeeShop.db.ConnectionManager;
import com.nexign.coffeeShop.db.DAO.OrderDAO;
import com.nexign.coffeeShop.db.DAO.ProductDAO;
import com.nexign.coffeeShop.domain.utils.JsonFileReader;
import com.nexign.coffeeShop.repository.InMemoryCoffeeRepository;
import com.nexign.coffeeShop.repository.InMemoryOrderRepository;
import com.nexign.coffeeShop.repository.JDBCOrderRepository;
import com.nexign.coffeeShop.repository.JDBCProductRepository;
import com.nexign.coffeeShop.services.OrderService;
import com.nexign.coffeeShop.services.factories.PaymentServiceFactory;
import com.nexign.coffeeShop.services.factories.ReceiptServiceFactory;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            var orderRequest = JsonFileReader.readOrderRequest("request.json");
//            var orderRepo = new InMemoryOrderRepository();
//            var productRepo = new InMemoryCoffeeRepository();
            var orderDAO = new OrderDAO(ConnectionManager.getInstance());
            var productDAO = new ProductDAO(ConnectionManager.getInstance());

            var productRepo = new JDBCProductRepository(productDAO);
            var orderRepo = new JDBCOrderRepository(orderDAO);
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
