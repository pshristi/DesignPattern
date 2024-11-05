package com.example.learninglld.stateDesignPattern.vendingMachineState;

import com.example.learninglld.stateDesignPattern.Coin;
import com.example.learninglld.stateDesignPattern.Inventory;
import com.example.learninglld.stateDesignPattern.Item;
import com.example.learninglld.stateDesignPattern.ItemShelf;
import com.example.learninglld.stateDesignPattern.VendingMachine;

import java.util.List;

public class HasMoneyState implements States {
    boolean isReadyToSelectProduct = false;

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
        System.out.println("Please select a product.");
        isReadyToSelectProduct = true;
    }

    @Override
    public void selectProduct(VendingMachine machine, Integer productCode) {
        if(!isReadyToSelectProduct) {
            System.out.println("Please click on select product button first to select a product.");
            return;
        }
        List<Coin> moneyIhave = machine.getCoinList();
        Integer totalAmount = moneyIhave.stream().mapToInt(Coin::getValue).sum();
        Inventory inventory = machine.getInventory();
        ItemShelf itemShelf = inventory.getItemShelfByItemCode(productCode);
        if(itemShelf != null) {
            if(itemShelf.isAvailable()) {
                if(totalAmount >= itemShelf.getItem().getPrice()) {
                    machine.setVendingMachineState(new DispenseState());
                    itemShelf.setAvailable(false);
                    if (totalAmount > itemShelf.getItem().getPrice()) {
                        totalAmount -= itemShelf.getItem().getPrice();
                        Coin coin = machine.getVendingMachineState().getChangeMoney(machine, totalAmount);
                    }
                    return;
                } else {
                    System.out.println("Insufficient funds. Click on refund button to get your refund.");
                    machine.setVendingMachineState(new DispenseState());
                    return;
                }
            }
            else {
                System.out.println("This product is not available. Click on refund button to get your refund.");
                machine.setVendingMachineState(new DispenseState());
                return;
            }
        }
        else {
            System.out.println("No such product found. Click on refund button to get your refund.");
            machine.setVendingMachineState(new DispenseState());
            return;
        }
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
