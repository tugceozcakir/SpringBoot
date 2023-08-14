package com.allianz.example.service;

import com.allianz.example.database.entity.*;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDTO,
        OrderRequestDTO, IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO>, IBaseRepository<OrderEntity>> {

    private OrderMapper orderMapper;

    private OrderEntityRepository orderEntityRepository;

    public OrderService(OrderMapper orderMapper, OrderEntityRepository orderEntityRepository) {
        this.orderMapper = orderMapper;
        this.orderEntityRepository = orderEntityRepository;
    }

    @Override
    public OrderMapper getMapper() {
        return null;
    }

    @Override
    public OrderEntityRepository getRepository() {
        return null;
    }

}