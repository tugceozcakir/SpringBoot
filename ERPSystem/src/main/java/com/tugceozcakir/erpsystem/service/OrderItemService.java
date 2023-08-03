package com.tugceozcakir.erpsystem.service;

import com.tugceozcakir.erpsystem.database.entity.OrderItemEntity;
import com.tugceozcakir.erpsystem.database.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItemEntity addOrderItem(OrderItemEntity orderItem) {
        return orderItemRepository.save(orderItem);
    }
/*
    public OrderItemEntity updateOrderItem(Long orderItemId, OrderItemEntity updatedOrderItem) {
        OrderItemEntity existingOrderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new NoSuchElementException("OrderItem not found with ID: " + orderItemId));

        existingOrderItem.setName(updatedOrderItem.getName());
        existingOrderItem.setPrice(updatedOrderItem.getPrice());
        existingOrderItem.setQuantity(updatedOrderItem.getQuantity());

        return orderItemRepository.save(existingOrderItem);
    }

 */

    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }

    public List<OrderItemEntity> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItemEntity getOrderItemById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new NoSuchElementException("OrderItem not found with ID: " + orderItemId));
    }

}

