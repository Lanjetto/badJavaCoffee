package solid.i;

public class Human implements Worker{
    @Override
    public void work() {
        System.out.println("Human work");
    }

    @Override
    public void eat() {
        System.out.println("Human eat");
    }
}
