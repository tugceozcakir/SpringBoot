package com.example.salesproject.service;

import com.example.salesproject.database.entity.SellerEntity;
import com.example.salesproject.database.entity.SettingEntity;
import com.example.salesproject.database.repository.SellerRepository;
import com.example.salesproject.database.repository.SettingRepository;
import com.example.salesproject.mapper.SellerMapper;
import com.example.salesproject.mapper.SettingMapper;
import com.example.salesproject.model.SettingDTO;
import com.example.salesproject.model.requestDTO.SellerRequestDTO;
import com.example.salesproject.model.requestDTO.SettingRequestDTO;
import com.example.salesproject.util.BaseRepository;
import com.example.salesproject.util.BaseService;
import com.example.salesproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService extends BaseService<SettingEntity, SettingDTO, SettingRequestDTO,
        SettingMapper, SettingRepository>  {

    @Autowired
    SettingRepository settingRepository;

    @Autowired
    SettingMapper settingMapper;

    @Override
    public SettingMapper getMapper() {
        return settingMapper;
    }

    @Override
    public SettingRepository getRepository() {
        return settingRepository;
    }
}
