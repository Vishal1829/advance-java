package org.advancedjava.designpattern.behavioral.state;

public class Fan {
    private FanState currentState;
    public Fan() {
        this.currentState = FanStateObjects.offState;
    }
    public void setState(FanState state) {
        this.currentState = state;
    }
    public void increaseSpeed() {
        currentState.handleRequest(this);
    }
}
