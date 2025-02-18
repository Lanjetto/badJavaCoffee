package designPatterns.creationalPatterns.builder;

public class SpicyPizzaBuilder extends PizzaBuilder{
    @Override
    public void buildDough() {
        pizza.setDough("Thick");
        pizza.setSauce("Spicy");
    }

    @Override
    public void buildSauce() {

    }
}
