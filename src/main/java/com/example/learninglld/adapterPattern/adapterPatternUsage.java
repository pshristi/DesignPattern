package com.example.learninglld.adapterPattern;

import com.example.learninglld.adapterPattern.adaptee.MyWeightMachine;
import com.example.learninglld.adapterPattern.adaptee.MyWeightmachineImpl;
import com.example.learninglld.adapterPattern.adapter.MyWeightMachineAdapter;
import com.example.learninglld.adapterPattern.adapter.MyWeightMachineAdapterImpl;

public class adapterPatternUsage {
    public static void useAdapterPattern() {
        MyWeightMachineAdapter myWeightMachineAdapter = new MyWeightMachineAdapterImpl(new MyWeightmachineImpl());
        System.out.println("Weight in kgs: " + myWeightMachineAdapter.getWeightInKgs());
    }
}

