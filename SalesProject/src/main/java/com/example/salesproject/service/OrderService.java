package com.example.salesproject.service;

import com.example.salesproject.database.entity.OrderEntity;
import com.example.salesproject.database.repository.OrderRepository;
import com.example.salesproject.mapper.OrderMapper;
import com.example.salesproject.model.OrderDTO;
import com.example.salesproject.model.requestDTO.OrderRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDTO, OrderRequestDTO,
        OrderMapper, OrderRepository> {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderMapper getMapper() {
        return orderMapper;
    }

    @Override
    public OrderRepository getRepository() {
        return orderRepository;
    }
}
