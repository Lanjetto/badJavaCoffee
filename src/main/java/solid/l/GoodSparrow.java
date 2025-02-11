package solid.l;

public class GoodSparrow extends GoodBird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow fly");
    }
}
