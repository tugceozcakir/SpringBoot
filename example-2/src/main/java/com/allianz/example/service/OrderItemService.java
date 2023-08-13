package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService extends BaseService<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Override
    public OrderItemDTO save(OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity orderItem = orderItemMapper.requestDTOToEntity(orderItemRequestDTO);
        orderItemRepository.save(orderItem);
        return orderItemMapper.entityToDTO(orderItem);
    }

    @Override
    public List<OrderItemDTO> getAll() {
        List<OrderItemEntity> orderItemEntities = orderItemRepository.findAll();
        return orderItemMapper.entityListToDTOList(orderItemEntities);
    }

    @Override
    public OrderItemDTO update(UUID uuid, OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity orderItemEntity = orderItemRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity == null) {
            return null;
        }
        return orderItemMapper.entityToDTO(orderItemRepository.save(orderItemMapper.requestDtoToExistEntity(
                orderItemRequestDTO, orderItemEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        OrderItemEntity orderItemEntity = orderItemRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity == null) {
            return false;
        }
        orderItemRepository.delete(orderItemEntity);
        return true;
    }

    @Override
    public OrderItemDTO getSettingByUuid(UUID uuid) {
        OrderItemEntity orderItemEntity = orderItemRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity == null) {
            return null;
        }
        return orderItemMapper.entityToDTO(orderItemEntity);
    }


}

