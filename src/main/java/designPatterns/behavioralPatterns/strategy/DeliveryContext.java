package designPatterns.behavioralPatterns.strategy;

public class DeliveryContext {
    private DeliveryStrategy deliveryStrategy;

    public DeliveryContext(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void executeDelivery(String address) {
        deliveryStrategy.deliver(address);
    }
}