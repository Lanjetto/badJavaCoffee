package com.nexign.coffeeShop.socket.client;

import java.io.IOException;
import java.net.URL;

public class URLExample {
    public static void main(String[] args) throws IOException {
        var url = new URL("http://www.google.com");
        var urlConnection = url.openConnection();

        var content = urlConnection.getContent();
        System.out.println(content);

        urlConnection.setDoOutput(true);

        try (var outputStream = urlConnection.getOutputStream()) {
            outputStream.write(new byte[] {1, 2, 3, 4});
        }
    }
}
