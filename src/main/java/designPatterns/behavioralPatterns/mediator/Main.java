package designPatterns.behavioralPatterns.mediator;

public class Main {
    public static void main(String[] args) {
        TaxiDispatcher taxiDispatcher = new TaxiDispatcher();

        Driver driver1 = new Driver("Ivan", taxiDispatcher);
        Driver driver2 = new Driver("Stas", taxiDispatcher);

        driver1.register();
        driver2.register();

        taxiDispatcher.requestTaxi("Alice");
        taxiDispatcher.requestTaxi("Bob");
        taxiDispatcher.requestTaxi("Charlie");

    }
}
