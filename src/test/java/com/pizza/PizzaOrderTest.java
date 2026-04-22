package com.pizza;

import com.pizza.observer.CustomerNotifier;
import com.pizza.observer.DeliveryNotifier;
import com.pizza.order.OrderStatus;
import com.pizza.order.PizzaOrder;
import com.pizza.pizza.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTest {
    @Test
    void tomatoSauceAddsToDescriptionAndPrice() {
        Pizza pizza = new TomatoSauce(new Dough());
        assertEquals("Dough, Tomato Sauce", pizza.getDescription());
        assertEquals(12.0, pizza.getPrice());
    }

    @Test
    void multipleToppingsStackCorrectly() {
        Pizza pizza = new Ham(new Mozzarella(new TomatoSauce(new Dough())));
        assertEquals("Dough, Tomato Sauce, Mozzarella, Ham", pizza.getDescription());
        assertEquals(22.5, pizza.getPrice());
    }

    @Test
    void customerIsNotifiedOnEveryStatusChange() {
        CustomerNotifier customer = new CustomerNotifier();
        Pizza pizza = new Mozzarella(new TomatoSauce(new Dough()));

        PizzaOrder order = new PizzaOrder("1", pizza);
        order.addObserver(customer);

        order.updateStatus(OrderStatus.RECEIVED);
        order.updateStatus(OrderStatus.PREPARING);
        order.updateStatus(OrderStatus.OUT_FOR_DELIVERY);
        order.updateStatus(OrderStatus.DELIVERED);

        assertEquals(4, customer.getReceivedAlerts().size());
        assertTrue(customer.getReceivedAlerts().get(1).contains("PREPARING"));
        assertTrue(customer.getReceivedAlerts().get(3).contains("DELIVERED"));
    }

    @Test
    void deliveryNotifierOnlyReceivesDeliveryStatuses() {
        DeliveryNotifier delivery = new DeliveryNotifier();
        PizzaOrder order = new PizzaOrder("3", new Dough());
        order.addObserver(delivery);

        order.updateStatus(OrderStatus.RECEIVED);
        order.updateStatus(OrderStatus.PREPARING);
        order.updateStatus(OrderStatus.OUT_FOR_DELIVERY);
        order.updateStatus(OrderStatus.DELIVERED);

        assertEquals(2, delivery.getReceivedAlerts().size());
        assertTrue(delivery.getReceivedAlerts().get(0).contains("OUT_FOR_DELIVERY"));
        assertTrue(delivery.getReceivedAlerts().get(1).contains("DELIVERED"));
    }
}
