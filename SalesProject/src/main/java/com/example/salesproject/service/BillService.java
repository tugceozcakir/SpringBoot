package com.example.salesproject.service;

import com.example.salesproject.database.entity.AddressEntity;
import com.example.salesproject.database.entity.BillEntity;
import com.example.salesproject.database.repository.BillRepository;
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
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO,
        BillMapper, BillRepository> {

    @Autowired
    BillMapper billMapper;

    @Autowired
    BillRepository billRepository;

    @Override
    public BillMapper getMapper() {
        return billMapper;
    }

    @Override
    public BillRepository getRepository() {
        return billRepository;
    }
}
