package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderItemEntity;
import com.tugceozcakir.erpsystem.database.repository.OrderRepository;
import com.tugceozcakir.erpsystem.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(CustomerEntity customer, List<OrderItemEntity> orderItems, OrderStatus status) {
        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);
        order.setOrder_items(orderItems);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}

