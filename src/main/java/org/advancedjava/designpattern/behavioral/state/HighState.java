package org.advancedjava.designpattern.behavioral.state;

public class HighState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned off.");
        fan.setState(FanStateObjects.offState);
    }
}
