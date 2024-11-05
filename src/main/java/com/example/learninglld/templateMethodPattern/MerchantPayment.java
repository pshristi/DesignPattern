package com.example.learninglld.templateMethodPattern;

public class MerchantPayment extends Payment {
    @Override
    void validateRequest() {
        // Implement validation logic for merchant payments
    }

    @Override
    void debitAmount() {
        // Implement debiting logic for merchant payments
    }

    @Override
    void debitGatewayCharges() {
        // Implement debiting gateway charges for merchant payments
    }

    @Override
    void creditAmount() {
        // Implement crediting logic for merchant payments
    }
}
