package com.nexign.coffeeShop.services.factories;

import com.nexign.coffeeShop.services.ConsolePrinter;
import com.nexign.coffeeShop.services.PrintService;

import java.util.HashMap;
import java.util.Map;

public class ReceiptServiceFactory {
    private static final Map<String, PrintService> receiptServiceMap = new HashMap<>();

    static {
        receiptServiceMap.put("CONSOLE", new ConsolePrinter());
    }

    public static PrintService getReceiptService(String receiptType) {
        return receiptServiceMap.getOrDefault(receiptType.toUpperCase(), new ConsolePrinter());
    }
}
