package com.nexign.coffeeShop.socket.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexign.coffeeShop.domain.DTO.OrderRequest;
import com.nexign.coffeeShop.domain.order.Order;
import com.nexign.coffeeShop.services.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class RequestHandler {
    private static final Logger LOGGER = Logger.getLogger(RequestHandler.class.getName());
    private final OrderService orderService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RequestHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    public void handle(Socket clientSocket) {
        try (clientSocket;
             var reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
             var writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

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

            String response = ResponseGenerator.generate(orderRequest, order);
            writer.println(response);

        } catch (IOException e) {
            LOGGER.severe("Error processing request: " + e.getMessage());
        }
    }
}
