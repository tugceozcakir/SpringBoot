package com.example.salesproject.service;

import com.example.salesproject.database.entity.CustomerEntity;
import com.example.salesproject.database.repository.CustomerRepository;
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
        CustomerMapper, CustomerRepository> {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerMapper getMapper() {
        return customerMapper;
    }

    @Override
    public CustomerRepository getRepository() {
        return customerRepository;
    }
}
