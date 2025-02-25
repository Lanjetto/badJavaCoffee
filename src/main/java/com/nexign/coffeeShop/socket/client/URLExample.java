package com.nexign.coffeeShop.socket.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLExample {
    public static void main(String[] args) throws IOException {
        var url = new URL("http://www.google.com");
        var urlConnection = url.openConnection();

        var content = urlConnection.getContent();
        System.out.println(content);

        urlConnection.setDoOutput(true);

        urlConnection.getOutputStream().write("Hello World".getBytes());
    }
}
