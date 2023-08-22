package com.example.salesproject.service;

import com.example.salesproject.database.entity.OrderItemEntity;
import com.example.salesproject.database.repository.OrderItemRepository;
import com.example.salesproject.database.specification.OrderItemSpecification;
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
        OrderItemMapper, OrderItemRepository, OrderItemSpecification> {

    @Autowired
    OrderItemRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    protected OrderItemMapper getMapper() {
        return this.orderItemMapper;
    }

    @Override
    protected OrderItemRepository getRepository() {
        return this.orderItemEntityRepository;
    }

    @Override
    protected OrderItemSpecification getSpecification() {
        return null;
    }
}
