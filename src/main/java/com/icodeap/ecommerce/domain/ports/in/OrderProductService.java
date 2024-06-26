package com.icodeap.ecommerce.domain.ports.in;

import com.icodeap.ecommerce.domain.ports.out.OrderProductRepository;
import com.icodeap.ecommerce.domain.models.Order;
import com.icodeap.ecommerce.domain.models.OrderProduct;

import java.util.List;

public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }
    public OrderProduct create(OrderProduct orderProduct){
        return orderProductRepository.create(orderProduct);
    }

    public Iterable<OrderProduct> getOrderProduct(){
        return orderProductRepository.getOrderProducts();
    }

    public List<OrderProduct> getOrderProductsByOrder(Order order){
        return orderProductRepository.getOrdersProductByOrder(order);
    }
}
