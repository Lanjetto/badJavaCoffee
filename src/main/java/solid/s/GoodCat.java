package solid.s;

public class GoodCat {
    private final String name;

    public GoodCat(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}
