package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    @Lazy
    OrderMapper orderMapper;

    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {

        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setCompanyName(entity.getCompanyName());
        dto.setTaxNumber(entity.getTaxNumber());
        dto.setTaxOffice(entity.getTaxOffice());
        dto.setIsCorporate(entity.getIsCorporate());
        dto.setPerson(personMapper.entityToDTO(entity.getPerson()));
        dto.setOrderList(orderMapper.entityListToDTOList(entity.getOrderList()));

        return dto;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCompanyName(dto.getCompanyName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setIsCorporate(dto.getIsCorporate());
        entity.setPerson(personMapper.dtoToEntity(dto.getPerson()));
        entity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));

        return entity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {

        List<CustomerDTO> dtoList = new ArrayList<>();
        for (CustomerEntity entity:customerEntities){
            CustomerDTO dto = entityToDTO(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<CustomerEntity> dtoListTOEntityList(List<CustomerDTO> customerDTOS) {
        List<CustomerEntity> entityList = new ArrayList<>();
        for (CustomerDTO dto:customerDTOS){
            CustomerEntity entity = dtoToEntity(dto);
            entityList.add(entity);

        }
        return entityList;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCompanyName(dto.getCompanyName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setIsCorporate(dto.getIsCorporate());
        entity.setPerson(personMapper.requestDTOToEntity(dto.getPerson()));

        return entity;
    }

    @Override
    public List<CustomerEntity> requestDtoListTOEntityList(List<CustomerRequestDTO> customerRequestDTOS) {
        return null;
    }

    @Override
    public CustomerEntity requestDtoToExistEntity(CustomerRequestDTO dto, CustomerEntity entity) {
        return null;
    }
}
