package designPatterns.creationalPatterns.builder;

public abstract class PizzaBuilder {
    protected Pizza pizza;

    public PizzaBuilder createPizza(){
        pizza = new Pizza();
        return this;
    }

    public Pizza build() {
        return pizza;
    }

    public abstract PizzaBuilder buildDough();
    public abstract PizzaBuilder buildSauce();
}
