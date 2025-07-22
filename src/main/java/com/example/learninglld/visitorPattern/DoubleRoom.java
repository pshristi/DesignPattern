package com.example.learninglld.visitorPattern;

public class DoubleRoom implements HotelElement {

    @Override
    public void accept(HotelVisitor visitor) {
        visitor.visit(this);
    }
}
