package com.example.learninglld.adapterPattern.adapter;

import com.example.learninglld.adapterPattern.adaptee.MyWeightMachine;

public class MyWeightMachineAdapterImpl implements MyWeightMachineAdapter {
    private MyWeightMachine myWeightmachine;
    public MyWeightMachineAdapterImpl(MyWeightMachine myWeightmachine) {
        this.myWeightmachine = myWeightmachine;
    }
    @Override
    public int getWeightInKgs() {
        int weightInPounds = myWeightmachine.getWeightInPounds();
        return weightInPounds * 2;
    }
}
