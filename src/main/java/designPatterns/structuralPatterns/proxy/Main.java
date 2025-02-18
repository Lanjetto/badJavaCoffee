package designPatterns.structuralPatterns.proxy;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        System.out.println("Image is didnt load");

        image.display();

        image.display();
    }
}
