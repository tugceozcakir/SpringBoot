package com.tugceozcakir.erpsystem.controller;

import com.tugceozcakir.erpsystem.database.entity.CustomerEntity;
import com.tugceozcakir.erpsystem.database.entity.OrderEntity;
import com.tugceozcakir.erpsystem.service.CustomerService;
import com.tugceozcakir.erpsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping("/add-order")
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        Long customerId = order.getCustomer().getId();
        CustomerEntity customer = customerService.getCustomerById(customerId);
        return orderService.createOrder(customer, order.getOrder_items(), order.getStatus());
    }

    @GetMapping("/all-order")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }
}

