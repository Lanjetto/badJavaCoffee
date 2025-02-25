package com.nexign.coffeeShop.socket.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.nio.file.Path;

import static java.net.http.HttpRequest.BodyPublishers;
import static java.net.http.HttpRequest.newBuilder;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HttpClientExample {
  public void run() throws IOException, InterruptedException {
        var client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        var request = newBuilder(URI.create("http://localhost:7777"))
                .header("content-type", "application/json")
                .POST(BodyPublishers.ofFile(Path.of("resources", "request.json")))
                .build();


        var response = client.send(request, ofString());
        System.out.println(response.statusCode());


    }
}
