package com.nexign.coffeeShop.socket.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.net.http.HttpRequest.BodyPublishers;
import static java.net.http.HttpRequest.newBuilder;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HttpClientExample {
  public void run() throws IOException, InterruptedException {
        var client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

      Path filePath;
      try {
          filePath = Paths.get(Objects.requireNonNull(HttpClientExample.class.getClassLoader()
                  .getResource("request.json")).toURI());
      } catch (URISyntaxException e) {
          throw new RuntimeException(e);
      }

        var request = newBuilder(URI.create("http://localhost:7777"))
                .header("content-type", "application/json")
                .POST(BodyPublishers.ofFile(filePath))
                .build();


        var response = client.send(request, ofString());
        System.out.println(response.statusCode());
        System.out.println("Response body: " + response.body());
    }
}
