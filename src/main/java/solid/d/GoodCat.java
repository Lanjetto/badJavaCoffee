package solid.d;

public class GoodCat {
    private final Food food;

    public GoodCat(Food food) {
        this.food = food;
    }

    public void eat() {
        food.consume();
    }
}
