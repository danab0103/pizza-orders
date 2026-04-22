package com.pizza.pizza;

public class Mozzarella extends ToppingDecorator {
    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mozzarella";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 4.5;
    }
}
