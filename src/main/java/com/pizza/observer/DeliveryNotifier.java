package com.pizza.observer;

import com.pizza.order.OrderStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeliveryNotifier implements OrderObserver {

    private final List<String> receivedAlerts = new ArrayList<>();

    @Override
    public void onStatusChanged(String orderId, OrderStatus newStatus) {
        if (newStatus == OrderStatus.OUT_FOR_DELIVERY || newStatus == OrderStatus.DELIVERED) {
            String alert = "Delivery: Order " + orderId + " is " + newStatus;
            receivedAlerts.add(alert);
            System.out.println(alert);
        }
    }

    public List<String> getReceivedAlerts() {
        return Collections.unmodifiableList(receivedAlerts);
    }
}
