package org.advancedjava.designpattern.behavioral.state;

public class MediumState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on high.");
        fan.setState(FanStateObjects.highState);
    }
}