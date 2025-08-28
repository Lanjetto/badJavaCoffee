package com.nexign.coffeeShop.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

//клиент
public class SocketRunner {
    public static void main(String[] args) throws IOException {
        var address = Inet4Address.getByName("localhost");
        try (var socket = new Socket(address, 7777);
             var input = new DataInputStream(socket.getInputStream());
             var output = new DataOutputStream(socket.getOutputStream())) {

            output.writeUTF("Hello World");
            System.out.println("Response from server: " + input.readUTF());
        }
    }
}
