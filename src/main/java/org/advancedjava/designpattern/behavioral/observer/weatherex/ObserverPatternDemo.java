package org.advancedjava.designpattern.behavioral.observer.weatherex;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();

        weatherStation.registerObserver(currentDisplay);

        weatherStation.setWeatherConditions(25.5f, 60.0f, 1012.0f);
        weatherStation.setWeatherConditions(28.0f, 65.0f, 1011.0f);
    }
}
/*

The Observer Pattern is a behavioral design pattern used to define a one-to-many dependency between objects.
When one object (the subject) changes its state, all dependent objects (observers) are notified and updated
automatically. This pattern is commonly used in scenarios where changes in one part of an application need to be
reflected in other parts without tightly coupling the components.

Explanation:
1. Observer Interface: Defines the update method that observers must implement.
2. Subject Interface: Provides methods for managing observers and notifying them of changes.
3. ConcreteSubject: WeatherStation maintains the state and notifies registered observers when the state changes.
4. ConcreteObserver: CurrentConditionsDisplay updates and displays the current weather conditions when notified.
5. Client Code: Sets up the subject and observer, and updates the weather conditions, triggering notifications to observers.

https://pandac.in/blogs/observer-pattern/
 */

