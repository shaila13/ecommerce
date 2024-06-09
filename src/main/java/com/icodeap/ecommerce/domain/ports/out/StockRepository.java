package com.icodeap.ecommerce.domain.ports.out;

import com.icodeap.ecommerce.domain.models.Product;
import com.icodeap.ecommerce.domain.models.Stock;

import java.util.List;

public interface StockRepository {
    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);
}
