package com.nexign.coffeeShop;

import java.io.PrintStream;
import java.util.Scanner;

public class CoffeeShop {

    private final PaymentProcessor processor = new PaymentProcessor();
    private final OrderItem orderItem = new OrderItem();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        orderItem.setCustomerName(customerName);

        while (true) {
            out.print("Enter item to add (or 'done' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            orderItem.addItem(input);
        }

        out.print("Choose payment method (Credit Card or Cash): ");
        String paymentMethod = scanner.nextLine();
        boolean success = processor.processPayment(paymentMethod);
        if (success) {
            out.println("Payment successful!");
            orderItem.printReceipt(out);
        } else {
            out.println("Payment failed.");
        }
        scanner.close();
    }
}