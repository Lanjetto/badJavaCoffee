package solid.i;

public class GoodHuman implements Workable, Eatable{
    @Override
    public void eat() {
        System.out.println("GoodHuman eat");
    }

    @Override
    public void work() {
        System.out.println("GoodHuman work");
    }
}
