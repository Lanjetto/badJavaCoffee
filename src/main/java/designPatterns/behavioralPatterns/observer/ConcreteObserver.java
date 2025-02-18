package designPatterns.behavioralPatterns.observer;

public class ConcreteObserver implements Observer{
    private String name;


    public ConcreteObserver(String name, Observable o) {
        this.name = name;
        o.registerObserver(this);
    }

    @Override
    public void update(String news) {
        System.out.println(name + " read news: " + news);
    }
}
