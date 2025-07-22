package com.example.learninglld.visitorPattern;

public interface HotelVisitor {
    void visit(SingleRoom singleRoom);
    void visit(DoubleRoom doubleRoom);
}
