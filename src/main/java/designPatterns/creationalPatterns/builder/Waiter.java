package designPatterns.creationalPatterns.builder;

public class Waiter {
    private final PizzaBuilder builder;

    public Waiter(PizzaBuilder builder) {
        this.builder = builder;
    }

    public void preparePizza() {
        Pizza pizza = builder.createPizza()
                .buildSauce()
                .buildDough()
                .build();

    }
}
