package com.newpiece.infrastructure.adapter;

import com.newpiece.application.repository.StockRepository;
import com.newpiece.infrastructure.entity.ProductEntity;
import com.newpiece.infrastructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {
    List<StockEntity> findByProductEntity(ProductEntity productEntity);
}
