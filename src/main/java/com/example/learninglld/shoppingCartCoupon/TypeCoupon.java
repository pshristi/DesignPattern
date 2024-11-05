package com.example.learninglld.shoppingCartCoupon;

import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

public class TypeCoupon extends CouponDecorator{
    static List<ProductType> EligibleTypes = Arrays.asList(
            ProductType.CLOTHING, ProductType.FURNITURE
    );
    Integer percentage;
    Product product;

    TypeCoupon(Product product, Integer percentage) {
        this.product = product;
        this.percentage = percentage;
    }

    @Override
    public float getPrice() {
        if(EligibleTypes.contains(product.getType())) {
            return product.getPrice() * (1 - percentage/100f);
        }
        return product.getPrice();
    }

    @Override
    public ProductType getType() {
        return this.product.getType();
    }

}
