package designPatterns.behavioralPatterns.observer;

public class Main {
    public static void main(String[] args) {
        ConcreteObservable concreteObservable = new ConcreteObservable();

        Observer parishioner1 = new ConcreteObserver("Ivan", concreteObservable);
        Observer parishioner2 = new ConcreteObserver("Stas", concreteObservable);
        Observer parishioner3 = new ConcreteObserver("Alice", concreteObservable);

        concreteObservable.setNewsChurch("News 1");

        concreteObservable.removeObserver(parishioner2);

        concreteObservable.setNewsChurch("News2");

    }
}
