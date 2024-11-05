package com.example.learninglld.shoppingCartCoupon;

import org.springframework.context.annotation.Primary;

public class PercentageCoupon extends CouponDecorator{
    Product product;
    Integer percentage;

    PercentageCoupon(Product product, Integer percentage) {
        this.product = product;
        this.percentage = percentage;
    }

    @Override
    public float getPrice() {
        return this.product.getPrice() * (1 - percentage / 100.0f);
    }

    @Override
    public ProductType getType() {
        return this.product.getType();
    }
}
