package com.icodeap.ecommerce.domain.ports.out;

import com.icodeap.ecommerce.domain.models.Order;
import com.icodeap.ecommerce.domain.models.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    public OrderProduct create (OrderProduct orderProduct);
    public Iterable<OrderProduct>  getOrderProducts();
    public List<OrderProduct> getOrdersProductByOrder(Order order);
}
