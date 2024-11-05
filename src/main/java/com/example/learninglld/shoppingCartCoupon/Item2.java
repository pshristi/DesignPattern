package com.example.learninglld.shoppingCartCoupon;

public class Item2 implements Product{
    String name;
    ProductType type;
    float price;
    public Item2(String name, float price) {
        this.name = name;
        this.price = price;
        this.type = ProductType.ELECTRONICS;
    }

    public float getPrice() {
        return this.price;
    }

    public ProductType getType() {
        return this.type;
    }
}
