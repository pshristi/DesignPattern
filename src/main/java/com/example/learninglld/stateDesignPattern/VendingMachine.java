package com.example.learninglld.stateDesignPattern;

import com.example.learninglld.stateDesignPattern.vendingMachineState.IdleState;
import com.example.learninglld.stateDesignPattern.vendingMachineState.States;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendingMachine {
    States vendingMachineState;
    List<Coin> coinList;
    Inventory inventory;

    VendingMachine() {
        this.coinList = new ArrayList<>();
        this.inventory = new Inventory(10);
        this.vendingMachineState = new IdleState();
    }
}
