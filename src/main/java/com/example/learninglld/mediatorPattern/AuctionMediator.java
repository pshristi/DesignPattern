package com.example.learninglld.mediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements Mediator {
    private List<Colleague> bidders = new ArrayList<>();
    @Override
    public void addBider(Colleague colleague) {
        this.bidders.add(colleague);
    }

    @Override
    public void placeBid(Colleague colleague, int bid) {
        for (Colleague bidder : bidders) {
            if (!bidder.getName().equals(colleague.getName())) {
                    bidder.receiveBid(bid);
            }
        }
    }
}
