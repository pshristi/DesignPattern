package com.example.learninglld.decoratorPattern;

public class Extraveggies extends ToppingDecorator {
    BasePizza pizza;
    Extraveggies(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public Integer cost() {
        return pizza.cost() + 10;
    }
}
