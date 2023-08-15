package com.example.salesproject.service;

import com.example.salesproject.database.entity.AddressEntity;
import com.example.salesproject.database.entity.BillEntity;
import com.example.salesproject.database.repository.AddresRepository;
import com.example.salesproject.database.repository.BillRepository;
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
        AddressMapper,AddresRepository> {

    @Autowired
    AddresRepository addressRepository;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public AddressMapper getMapper() {
        return addressMapper;
    }

    @Override
    public AddresRepository getRepository() {
        return addressRepository;
    }
}
