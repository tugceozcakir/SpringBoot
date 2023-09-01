package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.AdminEntity;
import com.tugceozcakir.healthtourismproject.database.entity.AirlineCompanyEntity;
import com.tugceozcakir.healthtourismproject.database.entity.AirplaneEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.model.*;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AdminRequestDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AirlineCompanyRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirlineCompanyMapper implements IBaseMapper<AirlineCompanyDTO, AirlineCompanyEntity, AirlineCompanyRequestDTO> {

    @Autowired
    AirplaneMapper airplaneMapper;

    @Override
    public AirlineCompanyDTO entityToDTO(AirlineCompanyEntity entity) {
        AirlineCompanyDTO dto = new AirlineCompanyDTO();
        dto.setCompanyName(entity.getCompanyName());
        dto.setContactNumber(entity.getContactNumber());
        List<AirplaneDTO> airplaneId = airplaneMapper.entityListToDTOList(entity.getAirplaneEntityList());
        if (airplaneId != null) {
            dto.setAirplaneEntityList(airplaneId);
        }
        //dto.setAirplaneEntityList(airplaneMapper.entityListToDTOList(entity.getAirplaneEntityList()));
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public AirlineCompanyEntity dtoToEntity(AirlineCompanyDTO dto) {
        AirlineCompanyEntity entity = new AirlineCompanyEntity();
        entity.setCompanyName(dto.getCompanyName());
        entity.setContactNumber(dto.getContactNumber());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        List<AirplaneEntity> airplaneId = airplaneMapper.dtoListTOEntityList(dto.getAirplaneEntityList());
        if (airplaneId != null) {
            entity.setAirplaneEntityList(airplaneId);
        }
        return entity;
    }

    @Override
    public List<AirlineCompanyDTO> entityListToDTOList(List<AirlineCompanyEntity> airlineCompanyEntities) {
        List<AirlineCompanyDTO> dtoList = new ArrayList<>();
        if (airlineCompanyEntities == null) {
            return null;
        }
        for(AirlineCompanyEntity airlineCompanyEntity : airlineCompanyEntities){
            dtoList.add(entityToDTO(airlineCompanyEntity));
        }
        return dtoList;
    }

    @Override
    public List<AirlineCompanyEntity> dtoListTOEntityList(List<AirlineCompanyDTO> airlineCompanyDTOS) {
        List<AirlineCompanyEntity> entityList = new ArrayList<>();
        if (airlineCompanyDTOS == null) {
            return null;
        }
        for(AirlineCompanyDTO airlineCompanyDTO : airlineCompanyDTOS){
            entityList.add(dtoToEntity(airlineCompanyDTO));
        }
        return entityList;
    }

    @Override
    public AirlineCompanyEntity requestDTOToEntity(AirlineCompanyRequestDTO dto) {
        AirlineCompanyEntity airlineCompanyEntity = new AirlineCompanyEntity();
        airlineCompanyEntity.setContactNumber(dto.getContactNumber());
        airlineCompanyEntity.setCompanyName(dto.getCompanyName());
        airlineCompanyEntity.setUuid(dto.getUuid());
        airlineCompanyEntity.setId(dto.getId());
        airlineCompanyEntity.setCreationDate(dto.getCreationDate());
        airlineCompanyEntity.setUpdatedDate(dto.getUpdatedDate());
        List<AirplaneEntity> airplaneId = airplaneMapper.requestDtoListTOEntityList(dto.getAirplaneEntityList());
        if (airplaneId != null) {
            airlineCompanyEntity.setAirplaneEntityList(airplaneId);
        }
        return airlineCompanyEntity;
    }

    @Override
    public List<AirlineCompanyEntity> requestDtoListTOEntityList(List<AirlineCompanyRequestDTO> airlineCompanyRequestDTOS) {
        List<AirlineCompanyEntity> airlineCompanyEntities = new ArrayList<>();
        if (airlineCompanyRequestDTOS == null) {
            return null;
        }
        for (AirlineCompanyRequestDTO requestDTO : airlineCompanyRequestDTOS)
            airlineCompanyEntities.add(requestDTOToEntity(requestDTO));
        return airlineCompanyEntities;
    }

    @Override
    public AirlineCompanyEntity requestDtoToExistEntity(AirlineCompanyEntity entity, AirlineCompanyRequestDTO airlineCompanyRequestDTO) {
        entity.setCompanyName(airlineCompanyRequestDTO.getCompanyName());
        entity.setContactNumber(airlineCompanyRequestDTO.getContactNumber());
        return entity;
    }

    @Override
    public PageDTO<AirlineCompanyDTO> pageEntityToPageDTO(Page<AirlineCompanyEntity> airlineCompanyEntities) {
        PageDTO<AirlineCompanyDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(airlineCompanyEntities.getTotalPages());
        dtoPage.setTotalElements(airlineCompanyEntities.getTotalElements());
        dtoPage.setSort(airlineCompanyEntities.getSort());
        dtoPage.setSize(airlineCompanyEntities.getSize());
        dtoPage.setNumber(airlineCompanyEntities.getNumber());
        dtoPage.setContent(entityListToDTOList(airlineCompanyEntities.getContent()));
        dtoPage.setHasContent(airlineCompanyEntities.hasContent());

        return dtoPage;
    }
}
