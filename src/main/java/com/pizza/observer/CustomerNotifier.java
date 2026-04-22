package com.pizza.observer;

import com.pizza.order.OrderStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerNotifier implements OrderObserver {

    private final List<String> receivedAlerts = new ArrayList<>();

    @Override
    public void onStatusChanged(String orderId, OrderStatus newStatus) {
        String alert = "Customer: Your order " + orderId + " is " + newStatus;
        receivedAlerts.add(alert);
        System.out.println(alert);
    }

    public List<String> getReceivedAlerts() {
        return Collections.unmodifiableList(receivedAlerts);
    }
}
