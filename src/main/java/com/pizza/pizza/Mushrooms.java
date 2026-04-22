package com.pizza.pizza;

public class Mushrooms extends ToppingDecorator {
    public Mushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mushrooms";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3.5;
    }
}
