package com.nexign.coffeeShop.domain.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexign.coffeeShop.domain.DTO.OrderRequest;

import java.io.IOException;
import java.io.InputStream;


public class JsonFileReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static OrderRequest readOrderRequest(String fileName) throws IOException {
        OrderRequest orderRequest;
        try (InputStream inputStream = JsonFileReader.class.getClassLoader().getResourceAsStream(fileName)){
            orderRequest = objectMapper.readValue(inputStream, OrderRequest.class);
        } catch (IOException e) {
            throw new IOException("File not found", e);
        }

        return orderRequest;
    }

}
