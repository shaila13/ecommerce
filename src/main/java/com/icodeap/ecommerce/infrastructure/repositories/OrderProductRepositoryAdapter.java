package com.icodeap.ecommerce.infrastructure.repositories;

import com.icodeap.ecommerce.domain.ports.out.OrderProductRepository;
import com.icodeap.ecommerce.domain.models.Order;
import com.icodeap.ecommerce.domain.models.OrderProduct;
import com.icodeap.ecommerce.infrastructure.mapper.OrderMapper;
import com.icodeap.ecommerce.infrastructure.mapper.OrderProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductRepositoryAdapter implements OrderProductRepository {
    private final OrderProductCrudRepository productCrudRepository;
    private final OrderMapper orderMapper;
    private  final OrderProductMapper orderProductMapper;

    public OrderProductRepositoryAdapter(OrderProductCrudRepository productCrudRepository, OrderMapper orderMapper, OrderProductMapper orderProductMapper) {
        this.productCrudRepository = productCrudRepository;
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductMapper.toOrderProduct( productCrudRepository.save(  orderProductMapper.toOrderProductEntity(orderProduct)));
    }

    @Override
    public Iterable<OrderProduct> getOrderProducts() {
        return orderProductMapper.toOrderProducts( productCrudRepository.findAll());
    }

    @Override
    public List<OrderProduct> getOrdersProductByOrder(Order order) {
        return orderProductMapper.toOrderProductsList( productCrudRepository.findByPkOrderEntity( orderMapper.toOrderEntity(order ) ) );
    }
}
