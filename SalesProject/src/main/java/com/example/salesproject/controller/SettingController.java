package com.example.salesproject.controller;

import com.example.salesproject.database.entity.SettingEntity;
import com.example.salesproject.database.repository.SettingRepository;
import com.example.salesproject.database.specification.SettingSpecification;
import com.example.salesproject.mapper.SettingMapper;
import com.example.salesproject.model.SettingDTO;
import com.example.salesproject.model.requestDTO.SettingRequestDTO;
import com.example.salesproject.service.SettingService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setting")
public class SettingController extends BaseController<
        SettingEntity,
        SettingDTO,
        SettingRequestDTO,
        SettingMapper,
        SettingRepository,
        SettingSpecification,
        SettingService> {

    @Autowired
    SettingService settingService;

    @Override
    protected SettingService getService() {
        return this.settingService;
    }
}
