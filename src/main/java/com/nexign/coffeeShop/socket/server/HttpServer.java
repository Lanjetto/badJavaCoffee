package com.nexign.coffeeShop.socket.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexign.coffeeShop.domain.DTO.OrderRequest;
import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.services.OrderService;
import com.nexign.coffeeShop.services.factories.PaymentServiceFactory;
import com.nexign.coffeeShop.services.factories.ReceiptServiceFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class HttpServer {
    private final int port;
    private static final Logger LOGGER = Logger.getLogger(HttpServer.class.getName());
    private final OrderService orderService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public HttpServer(int port, OrderService orderService) {
        this.port = port;
        this.orderService = orderService;
    }

    public void run() {

        try (var serverSocket = new ServerSocket(port);
             var socket = serverSocket.accept()) {
            LOGGER.info("Server is listening on port " + port);
            processSocket(socket);
        } catch (IOException e) {
            LOGGER.severe("Server error: " + e.getMessage());
        }
    }

    private void processSocket(Socket socket) {
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
        }
    }
}