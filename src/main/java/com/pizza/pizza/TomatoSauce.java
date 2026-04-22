package com.pizza.pizza;

public class TomatoSauce extends ToppingDecorator {
    public TomatoSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tomato Sauce";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2;
    }
}
