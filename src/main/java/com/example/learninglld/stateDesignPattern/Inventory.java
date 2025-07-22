package com.example.learninglld.stateDesignPattern;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Inventory {
    List<ItemShelf> itemShelfList;

    Inventory(Integer size) {
        this.initializeInventory(size);
    }

    public void addItem(Item item) {
        for (ItemShelf itemShelf : itemShelfList) {
            if (itemShelf.item.getItemCode() == item.getItemCode()) {
                if (!itemShelf.isAvailable()) {
                    itemShelf.item = item;
                    itemShelf.setAvailable(true);
                } else {
                    System.out.println("already item is present, you can not add item here");
                }
            }
        }
    }

    public void removeItem(Item item) {
        for (ItemShelf itemShelf : itemShelfList) {
            if (itemShelf.item.getItemCode() == item.getItemCode()) {
                if (itemShelf.isAvailable()) {
                    itemShelf.setAvailable(false);
                    itemShelfList.remove(itemShelf);
                    return;
                }
            }
        }
    }

    public ItemShelf getItemShelfByItemCode(Integer itemCode) {
        for (ItemShelf itemShelf : itemShelfList) {
            if (itemShelf.item.getItemCode() == itemCode) {
                return itemShelf;
            }
        }
        return null;
    }

    public void initializeInventory(Integer size) {
        List<ItemShelf> itemShelfList = new ArrayList<>();
        Integer itemCode = 101;
        for (int i = 0; i < size; i++) {
            Item item = new Item(itemCode, 10);
            ItemShelf itemShelf = new ItemShelf(item, true);
            itemShelfList.add(itemShelf);
        }
        this.setItemShelfList(itemShelfList);
    }
}
