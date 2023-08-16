package com.example.salesproject.service;

import com.example.salesproject.database.entity.TaxEntity;
import com.example.salesproject.database.repository.TaxRepository;
import com.example.salesproject.mapper.TaxMapper;
import com.example.salesproject.model.TaxDTO;
import com.example.salesproject.model.requestDTO.TaxRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaxService extends BaseService<TaxEntity, TaxDTO, TaxRequestDTO, TaxMapper, TaxRepository> {
    @Autowired
    TaxRepository taxEntityRepository;

    @Autowired
    TaxMapper taxMapper;

    @Override
    protected TaxMapper getMapper() {
        return this.taxMapper;
    }

    @Override
    protected TaxRepository getRepository() {
        return this.taxEntityRepository;
    }

    @Override
    public TaxDTO update(UUID uuid, TaxRequestDTO taxRequestDTO) {
        return super.update(uuid, taxRequestDTO);
    }
}
