package com.icodeap.ecommerce.infrastructure.repositories;

import com.icodeap.ecommerce.domain.ports.out.OrderRepository;
import com.icodeap.ecommerce.domain.models.Order;
import com.icodeap.ecommerce.domain.models.User;
import com.icodeap.ecommerce.infrastructure.mapper.OrderMapper;
import com.icodeap.ecommerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;
    private  final UserMapper userMapper;

    public OrderRepositoryAdapter(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder( orderCrudRepository.save( orderMapper.toOrderEntity(order) ) );
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders( orderCrudRepository.findAll() );
    }

    @Override
    public Iterable<Order> getOrdersByUser(User user) {
        return orderMapper.toOrders(orderCrudRepository.findByUser(userMapper.toUserEntity(user) ));
    }
}
