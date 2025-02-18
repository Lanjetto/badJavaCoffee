package designPatterns.behavioralPatterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class TaxiDispatcher implements Mediator{
    private List<Driver> drivers = new ArrayList<>();
    @Override
    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public void requestTaxi(String passengerName) {
        if (!drivers.isEmpty()) {
            Driver driver = drivers.remove(0);
            System.out.println("Такси назначено для " + passengerName + ". Водитель: " + driver.getName());
        } else {
            System.out.println("Нет доступных водителей для " + passengerName);
        }
    }
}
