package com.example.salesproject.controller;

import com.example.salesproject.database.entity.AddressEntity;
import com.example.salesproject.mapper.AddressMapper;
import com.example.salesproject.model.AddressDTO;
import com.example.salesproject.model.requestDTO.AddressRequestDTO;
import com.example.salesproject.service.AddressService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController<AddressEntity, AddressDTO, AddressRequestDTO,
        AddressService> {

    @Autowired
    AddressService addressService;

    @Override
    protected AddressService getBaseService() {
        return addressService;
    }
}
