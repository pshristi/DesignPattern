package com.example.learninglld.decoratorPattern;

public class placePizzaOrder {
    public Integer getPizzaPrice() {
        BasePizza pizza = new Extracheeze(new Extraveggies(new Vegdelight()));
        return pizza.cost();
    }
}
