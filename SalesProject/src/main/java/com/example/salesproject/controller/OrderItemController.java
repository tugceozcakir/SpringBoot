package com.example.salesproject.controller;

import com.example.salesproject.database.entity.OrderItemEntity;
import com.example.salesproject.database.repository.OrderItemRepository;
import com.example.salesproject.database.specification.OrderItemSpecification;
import com.example.salesproject.mapper.OrderItemMapper;
import com.example.salesproject.model.OrderItemDTO;
import com.example.salesproject.model.requestDTO.OrderItemRequestDTO;
import com.example.salesproject.service.OrderItemService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-item")
public class OrderItemController extends BaseController<
        OrderItemEntity,
        OrderItemDTO,
        OrderItemRequestDTO,
        OrderItemMapper,
        OrderItemRepository,
        OrderItemSpecification,
        OrderItemService> {

    @Autowired
    OrderItemService orderItemService;

    @Override
    protected OrderItemService getService() {
        return this.orderItemService;
    }
}