package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.entity.HotelEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.model.HospitalDTO;
import com.tugceozcakir.healthtourismproject.model.HotelDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.RoomDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.HotelRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements IBaseMapper<HotelDTO, HotelEntity, HotelRequestDTO> {

    @Autowired
    RoomMapper roomMapper;

    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {
        HotelDTO dto = new HotelDTO();
        dto.setContactNumber(entity.getContactNumber());
        dto.setCity(entity.getCity());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        List<RoomDTO> roomId = roomMapper.entityListToDTOList(entity.getRoomList());
        if (roomId != null) {
            dto.setRoomList(roomId);
        }
        return dto;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setContactNumber(dto.getContactNumber());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        List<RoomEntity> roomId = roomMapper.dtoListTOEntityList(dto.getRoomList());
        if (roomId != null) {
            entity.setRoomList(roomId);
        }
        return entity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<HotelEntity> hotelEntities) {
        List<HotelDTO> dtoList = new ArrayList<>();
        if (hotelEntities == null) {
            return null;
        }
        for (HotelEntity hotelEntity : hotelEntities){
            dtoList.add(entityToDTO(hotelEntity));
        }
        return dtoList;
    }

    @Override
    public List<HotelEntity> dtoListTOEntityList(List<HotelDTO> hotelDTOS) {
        List<HotelEntity> entityList = new ArrayList<>();
        if (hotelDTOS == null) {
            return null;
        }
        for(HotelDTO hotelDTO : hotelDTOS){
            entityList.add(dtoToEntity(hotelDTO));
        }
        return entityList;
    }

    @Override
    public HotelEntity requestDTOToEntity(HotelRequestDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setContactNumber(dto.getContactNumber());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        List<RoomEntity> roomId = roomMapper.requestDtoListTOEntityList(dto.getRoomList());
        if (roomId != null) {
            entity.setRoomList(roomId);
        }
        return entity;
    }

    @Override
    public List<HotelEntity> requestDtoListTOEntityList(List<HotelRequestDTO> hotelRequestDTOS) {
        List<HotelEntity> entityList = new ArrayList<>();
        if (hotelRequestDTOS == null) {
            return null;
        }
        for(HotelRequestDTO hotelRequestDTO : hotelRequestDTOS){
            entityList.add(requestDTOToEntity(hotelRequestDTO));
        }
        return entityList;
    }

    @Override
    public HotelEntity requestDtoToExistEntity(HotelEntity entity, HotelRequestDTO hotelRequestDTO) {
        entity.setContactNumber(hotelRequestDTO.getContactNumber());
        entity.setCity(hotelRequestDTO.getCity());
        entity.setName(hotelRequestDTO.getName());
        entity.setAddress(hotelRequestDTO.getAddress());
        List<RoomEntity> roomId = roomMapper.requestDtoListTOEntityList(hotelRequestDTO.getRoomList());
        if (roomId != null) {
            entity.setRoomList(roomId);
        }
        return entity;
    }

    @Override
    public PageDTO<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> hotelEntities) {
        PageDTO<HotelDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(hotelEntities.getTotalPages());
        pageDTO.setSort(hotelEntities.getSort());
        pageDTO.setSize(hotelEntities.getSize());
        pageDTO.setNumber(hotelEntities.getNumber());
        pageDTO.setHasContent(hotelEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(hotelEntities.getContent()));
        pageDTO.setTotalElements(hotelEntities.getTotalElements());

        return pageDTO;
    }
}
