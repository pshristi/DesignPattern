package com.example.learninglld.stateDesignPattern;

import lombok.Data;

@Data
public class Item {
    Integer itemCode;
    Integer price;
    Item(Integer itemCode, Integer price) {
        this.itemCode = itemCode;
        this.price = price;
    }
}
