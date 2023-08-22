package com.example.salesproject.service;

import com.example.salesproject.database.entity.CustomerEntity;
import com.example.salesproject.database.repository.CustomerRepository;
import com.example.salesproject.database.specification.CustomerSpecification;
import com.example.salesproject.mapper.CustomerMapper;
import com.example.salesproject.model.CustomerDTO;
import com.example.salesproject.model.requestDTO.CustomerRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDTO, CustomerRequestDTO,
        CustomerMapper, CustomerRepository, CustomerSpecification> {

    @Autowired
    CustomerRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    protected CustomerMapper getMapper() {
        return this.customerMapper;
    }

    @Override
    protected CustomerRepository getRepository() {
        return this.customerEntityRepository;
    }

    @Override
    protected CustomerSpecification getSpecification() {
        return null;
    }
}
