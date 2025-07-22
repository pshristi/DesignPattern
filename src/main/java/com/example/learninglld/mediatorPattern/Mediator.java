package com.example.learninglld.mediatorPattern;

public interface Mediator {
    void addBider(Colleague colleague);
    void placeBid(Colleague colleague, int bid);
}
