package com.example.salesproject.service;

import com.example.salesproject.database.entity.SellerEntity;
import com.example.salesproject.database.repository.SellerRepository;
import com.example.salesproject.mapper.SellerMapper;
import com.example.salesproject.model.SellerDTO;
import com.example.salesproject.model.requestDTO.SellerRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends BaseService<SellerEntity,
        SellerDTO, SellerRequestDTO, SellerMapper, SellerRepository> {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    public SellerMapper getMapper() {
        return sellerMapper;
    }

    @Override
    public SellerRepository getRepository() {
        return sellerRepository;
    }
}
