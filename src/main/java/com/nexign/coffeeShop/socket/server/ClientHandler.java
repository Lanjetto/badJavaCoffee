package com.nexign.coffeeShop.socket.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexign.coffeeShop.domain.DTO.OrderRequest;
import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.services.OrderService;
import com.nexign.coffeeShop.services.factories.PaymentServiceFactory;
import com.nexign.coffeeShop.services.factories.ReceiptServiceFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final OrderService orderService;
    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class.getName());

    public ClientHandler(Socket socket, OrderService orderService, ObjectMapper objectMapper) {
        this.socket = socket;
        this.orderService = orderService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run() {
        try (
                var reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                var writer = new PrintWriter(socket.getOutputStream(), true)
        ) {
            int contentLength = 0;
            String line;
            while (!(line = reader.readLine()).isEmpty()) {
                if (line.toLowerCase().startsWith("content-length:")) {
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
            }

            char[] body = new char[contentLength];
            reader.read(body);
            String jsonBody = new String(body);

            LOGGER.info("Received JSON: " + jsonBody);
            OrderRequest orderRequest = objectMapper.readValue(jsonBody, OrderRequest.class);
            Order order = orderService.createOrder(orderRequest);

            var paymentService = PaymentServiceFactory.getPaymentService(orderRequest.getPaymentMethod());
            paymentService.processPayment();
            var receiptService = ReceiptServiceFactory.getReceiptService(orderRequest.getReceiptType());
            String receiptOutput = receiptService.print(order);

            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/plain");
            writer.println("Content-Length: " + receiptOutput.length());
            writer.println();
            writer.println(receiptOutput);

        } catch (IOException e) {
            LOGGER.severe("Error processing request: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                LOGGER.warning("Error closing socket: " + e.getMessage());
            }
        }
    }
}
