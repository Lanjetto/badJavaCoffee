package designPatterns.behavioralPatterns.strategy;

public class Main {
    public static void main(String[] args) {

        DeliveryContext context = new DeliveryContext(new CourierDelivery());
        context.executeDelivery("ул. Ленина, д. 10");


        context.setDeliveryStrategy(new PickupDelivery());
        context.executeDelivery("ул. Пушкина, д. 5");

    }
}