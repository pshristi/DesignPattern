package com.example.learninglld.shoppingCartCoupon;

public class UseShoppingCartWithCoupons {
    public static void useShoppingCartWithCoupon() {
        Product item1 = new Item1("Sofa", 8000);
        Product item2 = new Item2("Earphone", 2000);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(item1);
        shoppingCart.addProduct(item2);

        System.out.println("Total bill value is" + shoppingCart.getTotalPrice());
    }
}
