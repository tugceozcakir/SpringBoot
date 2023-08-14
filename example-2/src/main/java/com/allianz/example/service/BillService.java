package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
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
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO,
        IBaseMapper<BillDTO, BillEntity, BillRequestDTO>, IBaseRepository<BillEntity>> {
    @Autowired
    private BillEntityRepository billEntityRepository;

    @Autowired
    private BillMapper billMapper;


    @Override
    public BillMapper getMapper() {
        return billMapper;
    }

    @Override
    public BillEntityRepository getRepository() {
        return billEntityRepository;
    }
}
