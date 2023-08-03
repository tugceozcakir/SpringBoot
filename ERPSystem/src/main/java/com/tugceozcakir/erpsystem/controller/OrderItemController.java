package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderItemEntity;
import com.tugceozcakir.erpsystem.service.CustomerService;
import com.tugceozcakir.erpsystem.service.OrderItemService;
import com.tugceozcakir.erpsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/all")
    public List<OrderItemEntity> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @PostMapping("/add")
    public OrderItemEntity addOrderItem(@RequestBody OrderItemEntity orderItem) {
        return orderItemService.addOrderItem(orderItem);
    }
/*
    @PutMapping("/update/{orderItemId}")
    public OrderItemEntity updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItemEntity updatedOrderItem) {
        return orderItemService.updateOrderItem(orderItemId, updatedOrderItem);
    }

 */

    @DeleteMapping("/delete/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}

