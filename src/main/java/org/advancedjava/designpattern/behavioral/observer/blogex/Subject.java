package org.advancedjava.designpattern.behavioral.observer.blogex;

import java.util.ArrayList;

public abstract class Subject {
    private final ArrayList<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObservers(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

}
