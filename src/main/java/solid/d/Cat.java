package solid.d;

public class Cat {
    private final DryFood food = new DryFood();

    public void eat() {
        food.consume();
    }
}
