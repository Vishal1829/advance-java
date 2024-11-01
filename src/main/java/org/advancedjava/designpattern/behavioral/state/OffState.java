package org.advancedjava.designpattern.behavioral.state;

public class OffState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on low.");
        fan.setState(FanStateObjects.lowState);
    }
}
