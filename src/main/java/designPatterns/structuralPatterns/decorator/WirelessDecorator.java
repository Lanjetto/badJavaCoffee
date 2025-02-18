package designPatterns.structuralPatterns.decorator;

public class WirelessDecorator extends Decorator{
    public WirelessDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addWireless();
    }

    private void addWireless() {
        System.out.println("add wireless");
    }
}
