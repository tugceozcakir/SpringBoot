package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
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
public class CustomerService extends BaseService<CustomerEntity,
        CustomerDTO, CustomerRequestDTO, IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO>,
        IBaseRepository<CustomerEntity>>{

    @Autowired
    private CustomerEntityRepository customerEntityRepository;

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public CustomerMapper getMapper() {
        return customerMapper;
    }

    @Override
    public CustomerEntityRepository getRepository() {
        return customerEntityRepository;
    }
}
