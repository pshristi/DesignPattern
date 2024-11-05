package com.example.learninglld.mediatorPattern;

public class Auctioner implements Colleague {
    String name;
    AuctionMediator mediator;

    public Auctioner(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addBider(this);
    }

    @Override
    public void placeBid(int amount) {
        mediator.placeBid(this, amount);
    }

    @Override
    public void receiveBid(int amount) {
        System.out.println(name + " received bid of " + amount);
    }

    public String getName() {
        return name;
    }
}
