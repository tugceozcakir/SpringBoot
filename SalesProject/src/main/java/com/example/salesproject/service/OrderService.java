package com.example.salesproject.service;

import com.example.salesproject.database.entity.OrderEntity;
import com.example.salesproject.database.repository.OrderRepository;
import com.example.salesproject.database.specification.OrderSpecification;
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
        OrderMapper, OrderRepository, OrderSpecification> {

    @Autowired
    OrderRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    protected OrderMapper getMapper() {
        return this.orderMapper;
    }

    @Override
    protected OrderRepository getRepository() {
        return this.orderEntityRepository;
    }

    @Override
    protected OrderSpecification getSpecification() {
        return null;
    }
}
