package designPatterns.behavioralPatterns.mediator;

public class Driver {
    private String name;
    private Mediator mediator;

    public Driver(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void register() {
        mediator.registerDriver(this);
    }
}