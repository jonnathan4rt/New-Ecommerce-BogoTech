package com.newpiece.infrastructure.adapter;

import com.newpiece.infrastructure.entity.OrderEntity;
import com.newpiece.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    public Iterable<OrderEntity> findByUser(UserEntity userEntity);
}
