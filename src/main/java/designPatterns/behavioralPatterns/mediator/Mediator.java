package designPatterns.behavioralPatterns.mediator;

public interface Mediator {
    void requestTaxi(String passengerName);
    void registerDriver(Driver driver);
}
