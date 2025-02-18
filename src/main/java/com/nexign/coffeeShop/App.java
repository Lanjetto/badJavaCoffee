package com.nexign.coffeeShop;

import com.nexign.coffeeShop.domain.*;
import com.nexign.coffeeShop.domain.decorator.Sugar;
import com.nexign.coffeeShop.repository.InMemoryCoffeeRepository;
import com.nexign.coffeeShop.repository.ProductRepository;
import com.nexign.coffeeShop.services.CardPayment;
import com.nexign.coffeeShop.services.ConsolePrinter;

import java.util.List;

public class App {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        CardPayment cardPayment = new CardPayment();
        ProductRepository repository = new InMemoryCoffeeRepository();


        Order order = new OrderBuilder(repository)
                .addItem("cappuccino", 2)
                .addItem("espresso", 1)
                .addDrink("latte", CupSize.M, 2)
                .addDrink("cappuccino", CupSize.M, new Sugar("сахар", 5.))
                .build();

        coffeeShop.createOrder(order, cardPayment, consolePrinter);
    }
}
