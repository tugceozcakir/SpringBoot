package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService extends BaseService<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public CustomerDTO save(CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customer = customerMapper.requestDTOToEntity(customerRequestDTO);
        customerEntityRepository.save(customer);
        return customerMapper.entityToDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerEntity> customerEntities = customerEntityRepository.findAll();
        return customerMapper.entityListToDTOList(customerEntities);
    }

    @Override
    public CustomerDTO update(UUID uuid, CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customer = customerEntityRepository.findByUuid(uuid).orElse(null);
        if (customer == null) {
            return null;
        }
        return customerMapper.entityToDTO(customerEntityRepository.save(customerMapper.requestDtoToExistEntity(
                customerRequestDTO, customer)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        CustomerEntity customerEntity = customerEntityRepository.findByUuid(uuid).orElse(null);
        if (customerEntity == null) {
            return false;
        }
        customerEntityRepository.delete(customerEntity);
        return true;
    }

    @Override
    public CustomerDTO getSettingByUuid(UUID uuid) {
        CustomerEntity customerEntity = customerEntityRepository.findByUuid(uuid).orElse(null);
        if (customerEntity == null) {
            return null;
        }
        return customerMapper.entityToDTO(customerEntity);
    }


}

