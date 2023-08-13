package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    //@Lazy
    OrderMapper orderMapper;

    @Override
    public BillEntity requestDtoToExistEntity(BillRequestDTO dto, BillEntity entity) {
        return null;
    }

    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO dto = new BillDTO();
        dto.setBillDate(entity.getBillDate());
        dto.setBillNo(entity.getBillNo());
        dto.setTaxRate(entity.getTaxRate());
        dto.setTaxAmount(entity.getTaxAmount());
        dto.setTotalSellPrice(entity.getTotalSellPrice());
        dto.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        dto.setOrder(orderMapper.entityToDTO(entity.getOrder()));

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public BillEntity dtoToEntity(BillDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setBillDate(dto.getBillDate());
        entity.setBillNo(dto.getBillNo());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {
        List<BillDTO> dtoList = new ArrayList<>();
        for (BillEntity entity:billEntities) {
            BillDTO dto =entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<BillEntity> dtoListTOEntityList(List<BillDTO> billDTOS) {
        List<BillEntity> entityList = new ArrayList<>();
        for (BillDTO dto:billDTOS) {
            BillEntity entity =dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setBillDate(dto.getBillDate());
        entity.setBillNo(dto.getBillNo());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setOrder(orderMapper.requestDTOToEntity(dto.getOrder()));

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<BillEntity> requestDtoListTOEntityList(List<BillRequestDTO> billRequestDTOS) {
        return null;
    }
}
