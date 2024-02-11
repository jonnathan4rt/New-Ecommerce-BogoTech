package com.newpiece.application.repository;

import com.newpiece.domain.Order;
import com.newpiece.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    public OrderProduct create (OrderProduct orderProduct);
    public Iterable<OrderProduct>  getOrderProducts();
    public List<OrderProduct> getOrdersProductByOrder(Order order);
}
