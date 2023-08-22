package com.example.salesproject.controller;

import com.example.salesproject.database.entity.CustomerEntity;
import com.example.salesproject.database.repository.CustomerRepository;
import com.example.salesproject.database.specification.CustomerSpecification;
import com.example.salesproject.mapper.CustomerMapper;
import com.example.salesproject.model.CustomerDTO;
import com.example.salesproject.model.requestDTO.CustomerRequestDTO;
import com.example.salesproject.service.CustomerService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseController<
        CustomerEntity,
        CustomerDTO,
        CustomerRequestDTO,
        CustomerMapper,
        CustomerRepository,
        CustomerSpecification,
        CustomerService> {

    @Autowired
    CustomerService customerService;

    @Override
    protected CustomerService getService() {
        return this.customerService;
    }
}