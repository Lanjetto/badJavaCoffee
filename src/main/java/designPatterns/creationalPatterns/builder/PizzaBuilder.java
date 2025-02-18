package designPatterns.creationalPatterns.builder;

public abstract class PizzaBuilder {
    protected Pizza pizza;

    public void createPizza(){
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
}
