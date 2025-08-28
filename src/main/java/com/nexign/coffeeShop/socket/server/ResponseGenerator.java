package com.nexign.coffeeShop.socket.server;

import com.nexign.coffeeShop.domain.DTO.OrderRequest;
import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.services.factories.PaymentServiceFactory;
import com.nexign.coffeeShop.services.factories.ReceiptServiceFactory;

public class ResponseGenerator {
    public static String generate(OrderRequest orderRequest, Order order) {
        var paymentService = PaymentServiceFactory.getPaymentService(orderRequest.getPaymentMethod());
        paymentService.processPayment();

        var receiptService = ReceiptServiceFactory.getReceiptService(orderRequest.getReceiptType());
        String receiptOutput = receiptService.print(order);

        return "HTTP/1.1 200 OK\r\n" +
               "Content-Type: text/plain\r\n" +
               "Content-Length: " + receiptOutput.length() + "\r\n" +
               "\r\n" +
               receiptOutput;
    }
}

