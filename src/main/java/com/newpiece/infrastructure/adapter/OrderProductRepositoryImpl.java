package com.newpiece.infrastructure.adapter;

import com.newpiece.application.repository.OrderProductRepository;
import com.newpiece.domain.Order;
import com.newpiece.domain.OrderProduct;
import com.newpiece.infrastructure.mapper.OrderMapper;
import com.newpiece.infrastructure.mapper.OrderProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final OrderProductCrudRepository orderProductCrudRepository;
    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;

    public OrderProductRepositoryImpl(OrderProductCrudRepository orderProductCrudRepository, OrderMapper orderMapper, OrderProductMapper orderProductMapper) {
        this.orderProductCrudRepository = orderProductCrudRepository;
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductMapper.toOrderProduct(orderProductCrudRepository.save(orderProductMapper.toOrderProductEntity(orderProduct)));
    }

    @Override
    public Iterable<OrderProduct> getOrderProducts() {
        return orderProductMapper.toOrderProducts(orderProductCrudRepository.findAll());
    }

    @Override
    public List<OrderProduct> getOrdersProductByOrder(Order order) {
        return orderProductMapper.toOrderProductsList(orderProductCrudRepository.findByPkOrderEntity(orderMapper.toOrderEntity(order)));
    }
}
