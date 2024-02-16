package com.newpiece.application.repository;

import com.newpiece.domain.Order;
import com.newpiece.domain.User;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();

    public Iterable<Order> getOrdersByUser(User user);

}
