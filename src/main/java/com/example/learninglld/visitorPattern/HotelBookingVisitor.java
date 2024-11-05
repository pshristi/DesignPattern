package com.example.learninglld.visitorPattern;

public class HotelBookingVisitor implements HotelVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Booking logic for single room");
    }
    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Booking logic for double room");
    }
}
