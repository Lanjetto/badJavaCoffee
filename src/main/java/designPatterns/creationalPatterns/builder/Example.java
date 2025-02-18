package designPatterns.creationalPatterns.builder;

public class Example {
    public static void main(String[] args) {
        Waiter waiter = new Waiter(new SpicyPizzaBuilder());
        waiter.preparePizza();
    }
}
