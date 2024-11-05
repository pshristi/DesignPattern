package com.example.learninglld.shoppingCartCoupon;

public class Item1 implements Product {
    String name;
    ProductType type;
    float price;
    public Item1(String name, float price) {
        this.name = name;
        this.price = price;
        this.type = ProductType.FURNITURE;
    }

    public float getPrice() {
        return this.price;
    }

    public ProductType getType() {
        return this.type;
    }
}
