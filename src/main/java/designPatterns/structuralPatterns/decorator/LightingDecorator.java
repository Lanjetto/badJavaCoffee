package designPatterns.structuralPatterns.decorator;

public class LightingDecorator extends Decorator{
    public LightingDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addLighting();
    }

    private void addLighting() {
        System.out.println("add light");
    }
}
