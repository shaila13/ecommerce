package com.icodeap.ecommerce.domain.ports.in;

import com.icodeap.ecommerce.domain.ports.out.StockRepository;
import com.icodeap.ecommerce.domain.models.Product;
import com.icodeap.ecommerce.domain.models.Stock;

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
