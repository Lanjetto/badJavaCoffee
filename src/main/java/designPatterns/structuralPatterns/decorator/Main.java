package designPatterns.structuralPatterns.decorator;

public class Main {
    public static void main(String[] args) {
        Component mouse = new Mouse();
        mouse.operation();

        Component lightingMouse = new LightingDecorator(mouse);
        lightingMouse.operation();

        Component wirelessDecorator = new WirelessDecorator(lightingMouse);
        wirelessDecorator.operation();
    }
}
