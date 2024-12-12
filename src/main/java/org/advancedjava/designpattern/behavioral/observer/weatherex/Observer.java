package org.advancedjava.designpattern.behavioral.observer.weatherex;

// Observer interface
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
