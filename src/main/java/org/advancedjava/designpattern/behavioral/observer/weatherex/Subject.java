package org.advancedjava.designpattern.behavioral.observer.weatherex;

// Subject (Observable) interface
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
