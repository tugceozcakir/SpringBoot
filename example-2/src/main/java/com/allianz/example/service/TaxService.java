package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaxService extends BaseService<TaxEntity, TaxDTO, TaxRequestDTO, IBaseMapper<TaxDTO, TaxEntity, TaxRequestDTO>, IBaseRepository<TaxEntity>> {

    @Autowired
    private TaxMapper taxMapper;

    @Autowired
    private TaxEntityRepository taxEntityRepository;

    @Override
    public TaxMapper getMapper() {
        return taxMapper;
    }

    @Override
    public TaxEntityRepository getRepository() {
        return taxEntityRepository;
    }
}

