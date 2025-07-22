package com.example.learninglld.mediatorPattern;

public class UseMediator {
    public static void useMediator() {
        AuctionMediator mediator = new AuctionMediator();
        Auctioner auctioner1 = new Auctioner("Alice", mediator);
        Auctioner auctioner2 = new Auctioner("Bob", mediator);

        auctioner1.placeBid(100);
        auctioner2.placeBid(200);
    }
}
