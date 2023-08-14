package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingsService extends BaseService<SettingsEntity,SettingsDTO,
        SettingRequestDTO, IBaseMapper<SettingsDTO, SettingsEntity, SettingRequestDTO>, IBaseRepository<SettingsEntity>> {

    @Autowired
    private SettingsMapper settingMapper;

    @Autowired
    private SettingsEntityRepository settingEntityRepository;


    @Override
    public SettingsMapper getMapper() {
        return settingMapper;
    }

    @Override
    public SettingsEntityRepository getRepository() {
        return settingEntityRepository;
    }

}
