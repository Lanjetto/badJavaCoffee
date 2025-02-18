package designPatterns.behavioralPatterns.strategy;

public class CourierDelivery implements DeliveryStrategy {
    @Override
    public void deliver(String address) {
        System.out.println("Доставка курьером по адресу: " + address);
    }
}
