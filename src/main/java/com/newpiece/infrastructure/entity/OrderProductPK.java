package com.newpiece.infrastructure.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class OrderProductPK {
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private  ProductEntity productEntity;
}
