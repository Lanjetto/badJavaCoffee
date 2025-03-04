package com.nexign.coffeeShop.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class HttpServerExecutors {
    private final int port;
    private static final Logger LOGGER = Logger.getLogger(HttpServerExecutors.class.getName());
    private final RequestHandler requestHandler;
    private final ExecutorService executorService = Executors.newFixedThreadPool(100);

    public HttpServerExecutors(int port, RequestHandler requestHandler) {
        this.port = port;
        this.requestHandler = requestHandler;
    }

    public void run() {
        try (var serverSocket = new ServerSocket(port)) {
            LOGGER.info("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(() -> {
                    try {
                        requestHandler.handle(clientSocket);
                    } catch (Exception e) {
                        LOGGER.severe("Error handling request: " + e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            LOGGER.severe("Server error: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}