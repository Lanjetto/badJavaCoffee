package solid.s;

public class BadCat {
    private final String name;

    public BadCat(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    //проблема, ведь чистить лоток нужно за любым животным
    public void cleanLitterBox() {
        System.out.println("cleaning litter box for " + name);
    }
}
