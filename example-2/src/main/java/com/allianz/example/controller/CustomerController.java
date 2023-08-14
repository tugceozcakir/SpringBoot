package com.allianz.example.controller;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.service.CustomerService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController<CustomerEntity, CustomerDTO, CustomerRequestDTO, CustomerService> {

    @Autowired
    CustomerService customerService;

    @Override
    protected CustomerService getService() {
        return customerService;
    }
}

