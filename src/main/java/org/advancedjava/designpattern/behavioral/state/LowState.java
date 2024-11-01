package org.advancedjava.designpattern.behavioral.state;

public class LowState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on medium.");
        fan.setState(FanStateObjects.mediumState);
    }
}
