package com.example.learninglld.adapterPattern.adaptee;

public class MyWeightmachineImpl implements MyWeightMachine {
    public MyWeightmachineImpl() {
    }
    @Override
    public int getWeightInPounds() {
        return 42;
    }
}
