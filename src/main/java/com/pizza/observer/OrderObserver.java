package com.pizza.observer;

import com.pizza.order.OrderStatus;

public interface OrderObserver {
    void onStatusChanged(String orderId, OrderStatus newStatus);
}
