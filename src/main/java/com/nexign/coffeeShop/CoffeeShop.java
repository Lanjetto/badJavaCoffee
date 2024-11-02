package com.nexign.coffeeShop;

import java.io.PrintStream;
import java.util.Scanner;

public class CoffeeShop {

    private final PaymentProcessor processor = new PaymentProcessor();
    private final CoffeeOrder order = new CoffeeOrder();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        order.setCustomerName(customerName);

        while (true) {
            out.print("Enter item to add (or 'done' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            order.addItem(input);
        }

        out.print("Choose payment method (Credit Card or Cash): ");
        String paymentMethod = scanner.nextLine();
        boolean success = processor.processPayment(paymentMethod);
        if (success) {
            out.println("Payment successful!");
            order.printReceipt(out);
        } else {
            out.println("Payment failed.");
        }
        scanner.close();
    }
}