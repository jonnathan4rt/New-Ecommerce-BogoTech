package com.newpiece.application.service;

import com.newpiece.application.repository.OrderRepository;
import com.newpiece.domain.Order;
import com.newpiece.domain.User;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order){
        return orderRepository.createOrder(order);
    }

    public Iterable<Order> getOrders(){
        return orderRepository.getOrders();
    }

    public Iterable<Order> getOrdersByUser(User user){
        return orderRepository.getOrdersByUser(user);
    }
}
