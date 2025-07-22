package com.example.learninglld.stateDesignPattern.vendingMachineState;

import com.example.learninglld.stateDesignPattern.Coin;
import com.example.learninglld.stateDesignPattern.VendingMachine;

public interface States {
    void clickOnInsertCoinButton(VendingMachine machine);
    void putCoins(VendingMachine machine, com.example.learninglld.stateDesignPattern.Coin coin);
    void clickOnSelectProductButton(VendingMachine machine);
    void selectProduct(VendingMachine machine, Integer productCode);
    void dispenseProduct(VendingMachine machine, Integer productCode);
    Coin getChangeMoney(VendingMachine machine, Integer totalAmount);
    Coin doFullRefund(VendingMachine machine);
}
