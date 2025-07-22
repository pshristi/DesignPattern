package com.example.learninglld.stateDesignPattern.vendingMachineState;

import com.example.learninglld.stateDesignPattern.Coin;
import com.example.learninglld.stateDesignPattern.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements States {
    boolean isReadyToAccpet = false;

    public IdleState() {}

    IdleState(VendingMachine machine) {
        machine.setCoinList(new ArrayList<>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) {
        System.out.println("Please insert coins.");
        isReadyToAccpet = true;
    }

    @Override
    public void putCoins(VendingMachine machine, com.example.learninglld.stateDesignPattern.Coin coin) {
        if(isReadyToAccpet) {
            machine.getCoinList().add(coin);
            System.out.println("Coin inserted: " + coin.getValue());
            machine.setVendingMachineState(new HasMoneyState());
        }
        System.out.println("Please click on insert coin button to insert coins.");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) {
        System.out.println("Please insert coins to select a product.");
    }

    @Override
    public void selectProduct(VendingMachine machine, Integer productCode) {
        System.out.println("Please insert coins to select a product.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, Integer productCode) {
        return;
    }

    @Override
    public Coin getChangeMoney(VendingMachine machine, Integer totalAmount) {
        return null;
    }

    @Override
    public Coin doFullRefund(VendingMachine machine) {
        return null;
    }
}
