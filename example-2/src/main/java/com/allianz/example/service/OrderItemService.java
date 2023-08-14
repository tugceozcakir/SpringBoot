package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO,
        OrderItemRequestDTO, IBaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO>,
        IBaseRepository<OrderItemEntity>> {

    @Autowired
    private OrderItemRepository orderItemEntityRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;


    @Override
    public OrderItemMapper getMapper() {
        return orderItemMapper;
    }

    @Override
    public OrderItemRepository getRepository() {
        return orderItemEntityRepository;
    }
}

