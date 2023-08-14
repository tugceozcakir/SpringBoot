package com.allianz.example.service;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class SellerService extends BaseService<SellerEntity, SellerDTO, SellerRequestDTO, IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO>, IBaseRepository<SellerEntity>> {
    @Autowired
    SellerEntityRepository sellerRepository;
    @Autowired
    SellerMapper sellerMapper;

    @Override
    public SellerMapper getMapper() {
        return sellerMapper;
    }

    @Override
    public SellerEntityRepository getRepository() {
        return sellerRepository;
    }
}
