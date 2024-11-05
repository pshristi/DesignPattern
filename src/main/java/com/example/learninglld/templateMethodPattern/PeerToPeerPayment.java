package com.example.learninglld.templateMethodPattern;

public class PeerToPeerPayment extends Payment {
    @Override
    void validateRequest() {
        // Implement validation logic for Peer to Peer payment
    }

    @Override
    void debitAmount() {
        // Implement debiting logic for Peer to Peer payment
    }

    @Override
    void debitGatewayCharges() {
        return; // No gateway charges for Peer to Peer payment
    }

    @Override
    void creditAmount() {
        // Implement crediting logic for Peer to Peer payment
    }
}
