package com.example.salesproject.service;

import com.example.salesproject.database.entity.AddressEntity;
import com.example.salesproject.database.entity.BillEntity;
import com.example.salesproject.database.repository.AddresRepository;
import com.example.salesproject.database.repository.BillRepository;
import com.example.salesproject.database.specification.AddressSpecification;
import com.example.salesproject.mapper.AddressMapper;
import com.example.salesproject.mapper.BillMapper;
import com.example.salesproject.model.AddressDTO;
import com.example.salesproject.model.BillDTO;
import com.example.salesproject.model.requestDTO.AddressRequestDTO;
import com.example.salesproject.model.requestDTO.BillRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressEntity, AddressDTO, AddressRequestDTO,
        AddressMapper,AddresRepository, AddressSpecification> {

    @Autowired
    AddresRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    AddressSpecification addressSpecification;

    @Override
    protected AddressMapper getMapper() {
        return this.addressMapper;
    }

    @Override
    protected AddresRepository getRepository() {
        return this.addressEntityRepository;
    }

    @Override
    protected AddressSpecification getSpecification() {
        return addressSpecification;
    }

}