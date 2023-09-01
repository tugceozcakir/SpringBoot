package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.model.AvailabilityDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AvailabilityRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AvailabilityMapper implements IBaseMapper<AvailabilityDTO, AvailabilityEntity, AvailabilityRequestDTO> {
    @Override
    public AvailabilityDTO entityToDTO(AvailabilityEntity entity) {
        AvailabilityDTO dto = new AvailabilityDTO();

        dto.setDate(entity.getDate());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public AvailabilityEntity dtoToEntity(AvailabilityDTO dto) {
        AvailabilityEntity entity = new AvailabilityEntity();

        entity.setDate(dto.getDate());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<AvailabilityDTO> entityListToDTOList(List<AvailabilityEntity> availabilityEntities) {
        List<AvailabilityDTO> dtoList = new ArrayList<>();
        if (availabilityEntities == null) {
            return null;
        }
        for(AvailabilityEntity availabilityEntity : availabilityEntities){
            dtoList.add(entityToDTO(availabilityEntity));
        }

        return dtoList;
    }

    @Override
    public List<AvailabilityEntity> dtoListTOEntityList(List<AvailabilityDTO> availabilityDTOS) {
        List<AvailabilityEntity> availabilityEntityList = new ArrayList<>();
        if (availabilityDTOS == null) {
            return null;
        }
        for(AvailabilityDTO availabilityDTO : availabilityDTOS){
            availabilityEntityList.add(dtoToEntity(availabilityDTO));
        }

        return availabilityEntityList;
    }

    @Override
    public AvailabilityEntity requestDTOToEntity(AvailabilityRequestDTO dto) {
        AvailabilityEntity entity = new AvailabilityEntity();
        entity.setEndTime(dto.getEndTime());
        entity.setDate(dto.getDate());
        entity.setStartTime(dto.getStartTime());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<AvailabilityEntity> requestDtoListTOEntityList(List<AvailabilityRequestDTO> availabilityRequestDTOS) {
        List<AvailabilityEntity> availabilityEntityList = new ArrayList<>();
        if (availabilityRequestDTOS == null) {
            return null;
        }
        for(AvailabilityRequestDTO availabilityRequestDTO : availabilityRequestDTOS){
            availabilityEntityList.add(requestDTOToEntity(availabilityRequestDTO));
        }

        return availabilityEntityList;
    }

    @Override
    public AvailabilityEntity requestDtoToExistEntity(AvailabilityEntity entity, AvailabilityRequestDTO availabilityRequestDTO) {
        entity.setStartTime(availabilityRequestDTO.getStartTime());
        entity.setDate(availabilityRequestDTO.getDate());
        entity.setEndTime(availabilityRequestDTO.getEndTime());

        return entity;
    }

    @Override
    public PageDTO<AvailabilityDTO> pageEntityToPageDTO(Page<AvailabilityEntity> availabilityEntities) {
        PageDTO<AvailabilityDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalElements(availabilityEntities.getTotalElements());
        pageDTO.setTotalPages(availabilityEntities.getTotalPages());
        pageDTO.setContent(entityListToDTOList(availabilityEntities.getContent()));
        pageDTO.setSize(availabilityEntities.getSize());
        pageDTO.setHasContent(availabilityEntities.hasContent());
        pageDTO.setSort(availabilityEntities.getSort());
        pageDTO.setNumber(availabilityEntities.getNumber());

        return pageDTO;
    }
}
