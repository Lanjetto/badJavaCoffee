package designPatterns.behavioralPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObservable implements Observable {
    private List<Observer> parishioners = new ArrayList<>();
    private String newsChurch;

    public void setNewsChurch(String news) {
        this.newsChurch = news;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        parishioners.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        parishioners.remove(o);
    }

    @Override
    public void notifyObservers() {
        parishioners.forEach(o -> o.update(newsChurch));
    }
}
