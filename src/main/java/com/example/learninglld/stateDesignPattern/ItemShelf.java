package com.example.learninglld.stateDesignPattern;

import lombok.Data;

@Data
public class ItemShelf {
    Item item;
    boolean isAvailable;
    ItemShelf(Item item, boolean isAvailable) {
        this.item = item;
        this.isAvailable = isAvailable;
    }
}
