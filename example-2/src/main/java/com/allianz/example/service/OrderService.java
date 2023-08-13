package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Autowired
    OrderEntityRepository orderEntityRepository;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderDTO save(OrderRequestDTO orderRequestDTO) {
        OrderEntity order = orderMapper.requestDTOToEntity(orderRequestDTO);
        orderEntityRepository.save(order);
        return orderMapper.entityToDTO(order);
    }

    @Override
    public List<OrderDTO> getAll() {
        List<OrderEntity> orderEntities = orderEntityRepository.findAll();
        return orderMapper.entityListToDTOList(orderEntities);
    }

    @Override
    public OrderDTO update(UUID uuid, OrderRequestDTO orderRequestDTO) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if (orderEntity == null) {
            return null;
        }
        return orderMapper.entityToDTO(orderEntityRepository.save(orderMapper.requestDtoToExistEntity(
                orderRequestDTO, orderEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if (orderEntity == null) {
            return false;
        }
        orderEntityRepository.delete(orderEntity);
        return true;
    }

    @Override
    public OrderDTO getSettingByUuid(UUID uuid) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if (orderEntity == null) {
            return null;
        }
        return orderMapper.entityToDTO(orderEntity);
    }
}
