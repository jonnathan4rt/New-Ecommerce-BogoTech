package com.newpiece.application.repository;

import com.newpiece.domain.Order;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();

}
