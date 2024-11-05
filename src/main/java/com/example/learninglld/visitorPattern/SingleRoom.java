package com.example.learninglld.visitorPattern;

public class SingleRoom implements HotelElement {

    @Override
    public void accept(HotelVisitor visitor) {
        visitor.visit(this);
    }
}
