package solid.i;

public class Robot implements Worker{
    @Override
    public void work() {
        System.out.println("Robot work");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException();
    }
}
