package com.example.learninglld.visitorPattern;

public interface HotelElement {
    void accept(HotelVisitor visitor);
}
