package com.newpiece.application.repository;

import com.newpiece.domain.Product;
import com.newpiece.domain.Stock;

import java.util.List;

public interface StockRepository<S, I extends Number> {

    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);
}
