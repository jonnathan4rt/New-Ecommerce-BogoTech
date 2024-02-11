package com.newpiece.infrastructure.adapter;

import com.newpiece.infrastructure.entity.OrderEntity;
import com.newpiece.infrastructure.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer> {
    List<OrderProductEntity> findByPkOrderEntity(OrderEntity orderEntity);

}
