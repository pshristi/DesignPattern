package com.example.learninglld.stateDesignPattern.vendingMachineState;

import com.example.learninglld.stateDesignPattern.Coin;
import com.example.learninglld.stateDesignPattern.Item;
import com.example.learninglld.stateDesignPattern.ItemShelf;
import com.example.learninglld.stateDesignPattern.VendingMachine;

import java.util.List;

public class DispenseState implements States{
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) {
        return;
    }

    @Override
    public void putCoins(VendingMachine machine, com.example.learninglld.stateDesignPattern.Coin coin) {
        return;
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) {
        return;
    }

    @Override
    public void selectProduct(VendingMachine machine, Integer productCode) {
        return;
    }

    @Override
    public void dispenseProduct(VendingMachine machine, Integer productCode) {
        System.out.println("Dispensing product...");
        System.out.println("Product has been dispensed");
        ItemShelf itemShelf = machine.getInventory().getItemShelfByItemCode(productCode);
        machine.getInventory().removeItem(itemShelf.getItem());
        machine.setVendingMachineState(new IdleState(machine));
    }

    @Override
    public Coin getChangeMoney(VendingMachine machine, Integer totalAmount) {
        for(Coin coin : Coin.values()) {
            if(totalAmount == coin.getValue()) {
                return coin;
            }
        }
        return null;
    }

    @Override
    public Coin doFullRefund(VendingMachine machine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList().get(0);
    }
}
