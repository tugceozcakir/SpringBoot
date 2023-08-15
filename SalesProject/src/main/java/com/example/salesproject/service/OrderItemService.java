package com.example.salesproject.service;

import com.example.salesproject.database.entity.OrderItemEntity;
import com.example.salesproject.database.repository.OrderItemRepository;
import com.example.salesproject.mapper.OrderItemMapper;
import com.example.salesproject.model.OrderItemDTO;
import com.example.salesproject.model.requestDTO.OrderItemRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO,
        OrderItemMapper, OrderItemRepository> {

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public OrderItemMapper getMapper() {
        return orderItemMapper;
    }

    @Override
    public OrderItemRepository getRepository() {
        return orderItemRepository;
    }
}
