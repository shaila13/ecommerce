package com.icodeap.ecommerce.domain.ports.out;

import com.icodeap.ecommerce.domain.models.Order;
import com.icodeap.ecommerce.domain.models.User;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
    public Iterable<Order> getOrdersByUser(User user);
}
