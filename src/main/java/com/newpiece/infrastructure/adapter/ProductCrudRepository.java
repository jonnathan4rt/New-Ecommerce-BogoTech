package com.newpiece.infrastructure.adapter;

import com.newpiece.infrastructure.entity.ProductEntity;
import com.newpiece.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository  extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity (UserEntity userEntity);
}
