package com.example.learninglld.templateMethodPattern;

public class UseTemplateMethodPattern {

    public static void useTemplateMethodPattern() {
        Payment payment = new MerchantPayment();
        payment.sendMoney();

        Payment payment2 = new PeerToPeerPayment();
        payment2.sendMoney();
    }
}
