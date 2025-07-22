package com.example.learninglld.stateDesignPattern;

public enum Coin {
    QUARTER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1);
    public Integer value;
    Coin(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
