package solid.o;

public class BadCatService {
    //проблема в том, что если появится новый тип, придется каждый раз добавлять его в этот if
    public void makeSound(String catType) {
        if (catType.equals("Home")) {
            System.out.println("Meow");
        } else if (catType.equals("Wild")) {
            System.out.println("Roar");
        } else {
            throw new IllegalArgumentException("Unknown cat type");
        }
    }
}
