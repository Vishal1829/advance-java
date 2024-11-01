package org.advancedjava.designpattern.behavioral.mediator;

public interface Colleague {

    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getName();
}
