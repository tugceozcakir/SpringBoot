package com.example.salesproject.service;

import com.example.salesproject.database.entity.SellerEntity;
import com.example.salesproject.database.repository.SellerRepository;
import com.example.salesproject.database.specification.SellerSpecification;
import com.example.salesproject.mapper.SellerMapper;
import com.example.salesproject.model.SellerDTO;
import com.example.salesproject.model.requestDTO.SellerRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends
        BaseService<SellerEntity, SellerDTO, SellerRequestDTO, SellerMapper, SellerRepository, SellerSpecification> {
    @Autowired
    SellerRepository sellerEntityRepository;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    protected SellerMapper getMapper() {
        return this.sellerMapper;
    }

    @Override
    protected SellerRepository getRepository() {
        return this.sellerEntityRepository;
    }

    @Override
    protected SellerSpecification getSpecification() {
        return null;
    }
}
