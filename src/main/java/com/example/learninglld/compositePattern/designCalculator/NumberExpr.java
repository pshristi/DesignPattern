package com.example.learninglld.compositePattern.designCalculator;

public class NumberExpr implements ArithmaticExpr {
    int number;

    public NumberExpr(int number) {
        this.number = number;
    }

    @Override
    public int evaluate() {
        return number;
    }
}
