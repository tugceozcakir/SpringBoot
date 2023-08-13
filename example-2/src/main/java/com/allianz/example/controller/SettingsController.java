package com.allianz.example.controller;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.service.SettingsService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/setting")
public class SettingsController extends BaseController<SettingsDTO, SettingsEntity, SettingRequestDTO, SettingsService> {

    @Autowired
    SettingsService settingService;

    @Override
    protected SettingsService getBaseService() {
        return settingService;
    }
}
