package org.advancedjava.designpattern.behavioral.mediator;

public class Client {
    public static void main(String[] args) {
        Auction auction = new Auction();
        Bidder bidder1 = new Bidder("Vishal", auction);
        Bidder bidder2 = new Bidder("lakshay", auction);
        Bidder bidder3 = new Bidder("ravi", auction);

        auction.placeBid(bidder1, 200000);
    }
}
/*
Mediator Pattern: It encourages loose coupling by keeping objects from referring
to each other explicitly and allows them to communicate through a mediator object.


 */
