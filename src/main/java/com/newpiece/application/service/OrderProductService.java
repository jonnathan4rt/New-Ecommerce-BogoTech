package com.newpiece.application.service;

import com.newpiece.application.repository.OrderProductRepository;
import com.newpiece.domain.Order;
import com.newpiece.domain.OrderProduct;

import java.util.List;

public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductRepository.create(orderProduct);
    }

    public Iterable<OrderProduct> getOrderProduct() {
        return orderProductRepository.getOrderProducts();
    }

    public List<OrderProduct> getOrderProductsByOrder(Order order) {
        return orderProductRepository.getOrdersProductByOrder(order);
    }
}
