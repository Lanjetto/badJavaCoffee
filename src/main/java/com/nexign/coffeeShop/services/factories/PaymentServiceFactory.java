package com.nexign.coffeeShop.services.factories;

import com.nexign.coffeeShop.services.CardPayment;
import com.nexign.coffeeShop.services.CashPayment;
import com.nexign.coffeeShop.services.PaymentService;

import java.util.HashMap;
import java.util.Map;

public class PaymentServiceFactory {
    private static final Map<String, PaymentService> paymentServiceMap = new HashMap<>();

    static {
        paymentServiceMap.put("CARD", new CardPayment());
        paymentServiceMap.put("CASH", new CashPayment());
    }

    public static PaymentService getPaymentService(String paymentMethod) {
        return paymentServiceMap.getOrDefault(paymentMethod.toUpperCase(), new CashPayment());
    }
}