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
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingsService extends BaseService<SettingsDTO, SettingsEntity, SettingRequestDTO> {

    @Autowired
    SettingsEntityRepository settingEntityRepository;

    @Autowired
    SettingsMapper settingMapper;

    @Override
    public SettingsDTO save(SettingRequestDTO settingRequestDTO) {
        SettingsEntity setting = settingMapper.requestDTOToEntity(settingRequestDTO);
        settingEntityRepository.save(setting);
        return settingMapper.entityToDTO(setting);
    }

    @Override
    public List<SettingsDTO> getAll() {
        List<SettingsEntity> settingsEntities = settingEntityRepository.findAll();
        return settingMapper.entityListToDTOList(settingsEntities);
    }

    @Override
    public SettingsDTO update(UUID uuid, SettingRequestDTO settingRequestDTO) {
        SettingsEntity setting = settingEntityRepository.findByUuid(uuid).orElse(null);
        if (setting == null) {
            return null;
        }
        return settingMapper.entityToDTO(settingEntityRepository.save(settingMapper.requestDtoToExistEntity(
                settingRequestDTO, setting)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        SettingsEntity settingsEntity = settingEntityRepository.findByUuid(uuid).orElse(null);
        if (settingsEntity == null) {
            return false;
        }
        settingEntityRepository.delete(settingsEntity);
        return true;
    }

    @Override
    public SettingsDTO getSettingByUuid(UUID uuid) {
        SettingsEntity settingsEntity = settingEntityRepository.findByUuid(uuid).orElse(null);
        if (settingsEntity == null) {
            return null;
        }
        return settingMapper.entityToDTO(settingsEntity);
    }


}
