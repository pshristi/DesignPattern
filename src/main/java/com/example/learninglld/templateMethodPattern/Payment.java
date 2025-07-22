package com.example.learninglld.templateMethodPattern;

abstract class Payment {
    abstract void validateRequest();
    abstract void debitAmount();
    abstract void debitGatewayCharges();
    abstract void creditAmount();

    public final void sendMoney() {
        validateRequest();
        debitAmount();
        debitGatewayCharges();
        creditAmount();
    }
}
