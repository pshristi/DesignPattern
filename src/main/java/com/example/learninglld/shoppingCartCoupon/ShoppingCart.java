package com.example.learninglld.shoppingCartCoupon;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> products;

    ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        Product productWithCoupon = new TypeCoupon(new PercentageCoupon(product, 10), 5);
        products.add(productWithCoupon);
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for(Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
