package com.nexign.coffeeShop.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer {
    public static void main(String[] args) throws IOException {

        try (var serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {

            System.out.println("Client request: " + inputStream.readUTF());
            outputStream.writeUTF("Hello, server!");
        }
    }
}
