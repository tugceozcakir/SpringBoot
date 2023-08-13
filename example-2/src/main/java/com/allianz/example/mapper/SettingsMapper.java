package com.allianz.example.mapper;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SettingsMapper implements IBaseMapper<SettingsDTO, SettingsEntity, SettingRequestDTO> {
    @Override
    public SettingsDTO entityToDTO(SettingsEntity entity) {
        SettingsDTO dto = new SettingsDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());

        return dto;
    }

    @Override
    public SettingsEntity dtoToEntity(SettingsDTO dto) {
        SettingsEntity entity = new SettingsEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());

        return entity;
    }

    @Override
    public List<SettingsDTO> entityListToDTOList(List<SettingsEntity> settingEntities) {
        List<SettingsDTO> dtoList = new ArrayList<>();
        for (SettingsEntity entity : settingEntities) {
            SettingsDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<SettingsEntity> dtoListTOEntityList(List<SettingsDTO> settingDTOS) {
        List<SettingsEntity> dtoList = new ArrayList<>();
        for (SettingsDTO dto : settingDTOS) {
            SettingsEntity entity = dtoToEntity(dto);
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public SettingsEntity requestDTOToEntity(SettingRequestDTO dto) {
        SettingsEntity entity = new SettingsEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        return entity;
    }

    @Override
    public List<SettingsEntity> requestDtoListTOEntityList(List<SettingRequestDTO> settingRequestDTOS) {
        return null;
    }
    public SettingsEntity requestDtoToExistEntity(SettingRequestDTO dto, SettingsEntity entity) {
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        return entity;
    }
}
