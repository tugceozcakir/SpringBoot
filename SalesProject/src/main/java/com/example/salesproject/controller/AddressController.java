package com.example.salesproject.controller;

import com.example.salesproject.database.entity.AddressEntity;
import com.example.salesproject.database.repository.AddresRepository;
import com.example.salesproject.mapper.AddressMapper;
import com.example.salesproject.model.AddressDTO;
import com.example.salesproject.model.requestDTO.AddressRequestDTO;
import com.example.salesproject.service.AddressService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController<
        AddressEntity,
        AddressDTO,
        AddressRequestDTO,
        AddressMapper,
        AddresRepository,
        AddressService> {
    @Autowired
    private AddressService addressService;
    @Override
    protected AddressService getService() {
        return addressService;
    }
}



