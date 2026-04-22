package com.pizza.pizza;

public class Dough implements Pizza {
    @Override
    public String getDescription() {
        return "Dough";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
