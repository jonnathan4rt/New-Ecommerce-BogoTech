package com.newpiece.infrastructure.adapter;

import com.newpiece.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {

}
