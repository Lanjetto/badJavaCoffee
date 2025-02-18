package designPatterns.creationalPatterns.builder;

public class Waiter {
    private final PizzaBuilder builder;

    public Waiter(PizzaBuilder builder) {
        this.builder = builder;
    }

    public void preparePizza() {
        builder.createPizza();
        builder.buildDough();
        builder.buildSauce();
    }
}
