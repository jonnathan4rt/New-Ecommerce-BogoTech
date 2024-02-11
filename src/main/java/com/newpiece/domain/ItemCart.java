package com.newpiece.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@ToString
public class ItemCart {
    private Integer idProduct;
    private String nameProduct;
    private Integer quantity;
    private BigDecimal price;

    public BigDecimal getTotalPriceItem(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
