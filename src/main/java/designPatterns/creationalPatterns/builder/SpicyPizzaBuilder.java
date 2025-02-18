package designPatterns.creationalPatterns.builder;

public class SpicyPizzaBuilder extends PizzaBuilder{
    @Override
    public PizzaBuilder buildDough() {
        pizza.setDough("Thick");
        return this;
    }

    @Override
    public PizzaBuilder buildSauce() {
        pizza.setSauce("Spicy");
        return this;
    }

}
