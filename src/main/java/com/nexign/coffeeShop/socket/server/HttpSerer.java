package com.nexign.coffeeShop.socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpSerer {
    private int port;

    public HttpSerer(int port) {
        this.port = port;
    }

    public void run() {
        try (var serverSocket = new ServerSocket(port);
             var socket = serverSocket.accept()) {
            processSocket(socket);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
