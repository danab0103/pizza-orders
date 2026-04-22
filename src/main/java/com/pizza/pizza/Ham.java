package com.pizza.pizza;

public class Ham extends ToppingDecorator {
    public Ham(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Ham";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 6;
    }
}
