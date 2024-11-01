package org.advancedjava.designpattern.behavioral.mediator;

public class Bidder implements Colleague {

    private final String name;
    private final AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        this.auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        auctionMediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println("Bidder: " + name + " got the notification that someone has put bid " +
                "of : " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
