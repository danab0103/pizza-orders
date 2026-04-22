package com.pizza;

import com.pizza.observer.CustomerNotifier;
import com.pizza.observer.DeliveryNotifier;
import com.pizza.order.OrderStatus;
import com.pizza.order.PizzaOrder;
import com.pizza.pizza.*;

public class Main {

    public static void main(String[] args) {
        Pizza margherita = new Mozzarella(new TomatoSauce(new Dough()));
        Pizza hamPizza = new Ham(new Mozzarella(new TomatoSauce(new Dough())));
        Pizza hamAndMushroomsPizza = new Mushrooms(new Ham(new Mozzarella(new TomatoSauce(new Dough()))));

        System.out.println(margherita.getDescription() + " -> " + margherita.getPrice());
        System.out.println(hamPizza.getDescription() + " -> " + hamPizza.getPrice() + " RON");
        System.out.println(hamAndMushroomsPizza.getDescription() + " -> " + hamAndMushroomsPizza.getPrice() + " RON");
        System.out.println();

        CustomerNotifier customer = new CustomerNotifier();
        DeliveryNotifier delivery = new DeliveryNotifier();

        PizzaOrder order = new PizzaOrder("1", hamPizza);
        order.addObserver(customer);
        order.addObserver(delivery);

        order.updateStatus(OrderStatus.RECEIVED);
        order.updateStatus(OrderStatus.PREPARING);
        order.updateStatus(OrderStatus.OUT_FOR_DELIVERY);
        order.updateStatus(OrderStatus.DELIVERED);
    }
}
