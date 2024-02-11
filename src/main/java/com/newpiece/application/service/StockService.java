package com.newpiece.application.service;

import com.newpiece.application.repository.StockRepository;
import com.newpiece.domain.Product;
import com.newpiece.domain.Stock;


import java.util.List;

public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock saveStock(Stock stock){
        return stockRepository.saveStock(stock);
    }

    public List<Stock> getStockByProduct(Product product){
        return stockRepository.getStockByProduct(product);
    }

}

