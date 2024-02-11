package com.newpiece.infrastructure.mapper;

import com.newpiece.domain.OrderProduct;
import com.newpiece.infrastructure.entity.OrderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, OrderMapper.class})
public interface OrderProductMapper {
    @Mappings(
            {
                    @Mapping(source = "pk.productEntity", target = "product"),
                    @Mapping(source = "quantity", target = "quantity"),
                    @Mapping(source = "pk.orderEntity", target = "order"),

            }
    )
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);
    Iterable<OrderProduct> toOrderProducts( Iterable<OrderProductEntity> orderProductEntities);
    List<OrderProduct> toOrderProductsList(Iterable<OrderProductEntity> orderProductEntities);

    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);
}
