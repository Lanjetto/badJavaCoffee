package designPatterns.behavioralPatterns.strategy;

public class PickupDelivery implements DeliveryStrategy {
    @Override
    public void deliver(String address) {
        System.out.println("Самовывоз из пункта выдачи: " + address);
    }
}
