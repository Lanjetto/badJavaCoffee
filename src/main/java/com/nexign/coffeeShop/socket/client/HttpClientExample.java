package com.nexign.coffeeShop.socket.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import static java.net.http.HttpRequest.BodyPublishers.ofFile;
import static java.net.http.HttpRequest.newBuilder;
import static java.net.http.HttpResponse.BodyHandlers;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        Path filePath;
        try {
            filePath = Paths.get(Objects.requireNonNull(HttpClientExample.class.getClassLoader()
                    .getResource("request.json")).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        var request = newBuilder(URI.create("http://localhost:7777"))
                .headers("content-type", "application/json")
                .POST(ofFile(filePath))
                .build();

//        var response = client.send(request, BodyHandlers.ofString());
        var response1 = client.sendAsync(request, BodyHandlers.ofString());
        var response2 = client.sendAsync(request, BodyHandlers.ofString());
        var response3 = client.sendAsync(request, BodyHandlers.ofString());

        Stream.of(response1, response2, response3).forEach(future ->
            future.thenAccept(response -> {
                System.out.println("Response code: " + response.statusCode());
                System.out.println("Response body: " + response.body());
            }).join());


    }
}
