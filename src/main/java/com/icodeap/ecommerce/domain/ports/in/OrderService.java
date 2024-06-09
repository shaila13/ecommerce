package com.icodeap.ecommerce.domain.ports.in;

import com.icodeap.ecommerce.domain.ports.out.OrderRepository;
import com.icodeap.ecommerce.domain.models.Order;
import com.icodeap.ecommerce.domain.models.User;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order){
        return  orderRepository.createOrder(order);
    }

    public Iterable<Order> getOrders(){
        return  orderRepository.getOrders();
    }

    public Iterable<Order> getOrdersByuser(User user){
        return orderRepository.getOrdersByUser(user);
    }
}
