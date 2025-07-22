package com.example.learninglld.decoratorPattern;

public class Extracheeze extends ToppingDecorator {
    BasePizza pizza;
    Extracheeze(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public Integer cost() {
        return pizza.cost() + 20;
    }
}
