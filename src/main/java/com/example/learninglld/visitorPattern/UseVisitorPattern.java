package com.example.learninglld.visitorPattern;

public class UseVisitorPattern {
    public static void useVisitorPattern() {
        HotelElement singleRoom = new SingleRoom();
        HotelElement doubleRoom = new DoubleRoom();

        HotelVisitor hotelVisitor = new HotelPricingVisitor();
        singleRoom.accept(hotelVisitor);
        doubleRoom.accept(hotelVisitor);

        HotelVisitor hotelBookingVisitor = new HotelBookingVisitor();
        doubleRoom.accept(hotelBookingVisitor);
    }
}
