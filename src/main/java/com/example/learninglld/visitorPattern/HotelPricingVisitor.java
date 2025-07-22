package com.example.learninglld.visitorPattern;

public class HotelPricingVisitor implements HotelVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Single room price: 1000");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Double room price: 3000");
    }
}
