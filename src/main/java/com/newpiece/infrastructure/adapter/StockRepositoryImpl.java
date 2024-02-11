package com.newpiece.infrastructure.adapter;

import com.newpiece.application.repository.StockRepository;
import com.newpiece.domain.Product;
import com.newpiece.domain.Stock;
import com.newpiece.infrastructure.mapper.ProductMapper;
import com.newpiece.infrastructure.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRepositoryImpl  implements StockRepository {

    private final StockCrudRepository stockCrudRepository;
    private final StockMapper stockMapper;
    private final ProductMapper productMapper;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository, StockMapper stockMapper, ProductMapper productMapper) {
        this.stockCrudRepository = stockCrudRepository;
        this.stockMapper = stockMapper;
        this.productMapper = productMapper;
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockMapper.toStock(stockCrudRepository.save(stockMapper.toStockEntity(stock)));
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return stockMapper.toStocks( stockCrudRepository.findByProductEntity(productMapper.toProductEntity(product)) );
    }
}
