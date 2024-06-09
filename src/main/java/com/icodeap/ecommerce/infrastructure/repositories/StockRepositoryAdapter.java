package com.icodeap.ecommerce.infrastructure.repositories;

import com.icodeap.ecommerce.domain.ports.out.StockRepository;
import com.icodeap.ecommerce.domain.models.Product;
import com.icodeap.ecommerce.domain.models.Stock;
import com.icodeap.ecommerce.infrastructure.mapper.ProductMapper;
import com.icodeap.ecommerce.infrastructure.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRepositoryAdapter implements StockRepository {

    private final StockCrudRepository stockCrudRepository;
    private final StockMapper stockMapper;
    private final ProductMapper productMapper;

    public StockRepositoryAdapter(StockCrudRepository stockCrudRepository, StockMapper stockMapper, ProductMapper productMapper) {
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
