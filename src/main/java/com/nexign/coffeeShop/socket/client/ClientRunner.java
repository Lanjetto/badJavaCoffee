package com.nexign.coffeeShop.socket.client;

import java.io.IOException;


public class ClientRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        new HttpClientExample().run();
    }
}
