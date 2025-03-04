package com.nexign.coffeeShop.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        var localhost = Inet4Address.getByName("localhost");
        try (var socket = new Socket(localhost, 7777);
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {

            outputStream.writeUTF("Hello World");
            System.out.println("Response from server " + inputStream.readUTF());
        }

    }
}
