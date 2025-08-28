package com.nexign.coffeeShop.socket.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexign.coffeeShop.services.OrderService;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class HttpServerCopy {
    private final int port;
    private static final Logger LOGGER = Logger.getLogger(HttpServerCopy.class.getName());
    private final OrderService orderService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public HttpServerCopy(int port, OrderService orderService) {
        this.port = port;
        this.orderService = orderService;
    }

    public void run() {
        try (var serverSocket = new ServerSocket(port)) {
            LOGGER.info("Server is listening on port " + port);
            while (true) {
                var socket = serverSocket.accept();
                LOGGER.info("Accepted connection from " + socket.getInetAddress());
                new Thread(new ClientHandler(socket, orderService, objectMapper)).start();
            }
        } catch (IOException e) {
            LOGGER.severe("Server error: " + e.getMessage());
        }
    }
}