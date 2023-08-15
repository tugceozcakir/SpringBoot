package com.example.salesproject.controller;

import com.example.salesproject.database.entity.OrderEntity;
import com.example.salesproject.database.repository.OrderRepository;
import com.example.salesproject.mapper.OrderMapper;
import com.example.salesproject.model.OrderDTO;
import com.example.salesproject.model.requestDTO.OrderRequestDTO;
import com.example.salesproject.service.OrderService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController<
        OrderEntity,
        OrderDTO,
        OrderRequestDTO,
        OrderMapper,
        OrderRepository,
        OrderService> {

    @Autowired
    OrderService orderService;

    @Override
    protected OrderService getService() {
        return orderService;
    }
}
