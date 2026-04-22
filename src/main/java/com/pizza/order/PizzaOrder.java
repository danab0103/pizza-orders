package com.pizza.order;

import com.pizza.observer.OrderObserver;
import com.pizza.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {

    private final String id;
    private final Pizza pizza;
    private final List<OrderObserver> observers = new ArrayList<>();
    private OrderStatus status;

    public PizzaOrder(String id, Pizza pizza) {
        this.id = id;
        this.pizza = pizza;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.onStatusChanged(id, status);
        }
    }
}
