package com.icodeap.ecommerce.domain.ports.out;

import com.icodeap.ecommerce.domain.models.Product;
import com.icodeap.ecommerce.domain.models.User;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);
}
