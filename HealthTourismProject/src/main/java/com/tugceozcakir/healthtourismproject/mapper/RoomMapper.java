package com.tugceozcakir.healthtourismproject.mapper;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.model.AvailabilityDTO;
import com.tugceozcakir.healthtourismproject.model.PageDTO;
import com.tugceozcakir.healthtourismproject.model.ReservationDTO;
import com.tugceozcakir.healthtourismproject.model.RoomDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.RoomRequestDTO;
import com.tugceozcakir.healthtourismproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper implements IBaseMapper<RoomDTO, RoomEntity, RoomRequestDTO> {

    @Autowired
    AvailabilityMapper availabilityMapper;

    @Override
    public RoomDTO entityToDTO(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        //dto.setHotelEntity(entity.getHotelEntity());
        dto.setPrice(entity.getPrice());
        dto.setRoomType(entity.getRoomType());
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setCreationDate(entity.getCreationDate());

        List<AvailabilityDTO> availabilityId = availabilityMapper.entityListToDTOList(entity.getCheckInTime());
        if (availabilityId != null) {
            dto.setCheckInTime(availabilityId);
        }
        return dto;
    }

    @Override
    public RoomEntity dtoToEntity(RoomDTO dto) {
        RoomEntity entity = new RoomEntity();
        //entity.setHotelEntity(dto.getHotelEntity());
        entity.setPrice(dto.getPrice());
        entity.setRoomType(dto.getRoomType());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCreationDate(dto.getCreationDate());
       /* List<ReservationEntity> reservationId = reservationMapper.dtoListTOEntityList(dto.getReservation());
        if (reservationId != null) {
            entity.setReservation(reservationId);
        }

        */
        List<AvailabilityEntity> availabilityId = availabilityMapper.dtoListTOEntityList(dto.getCheckInTime());
        if (availabilityId != null) {
            entity.setCheckInTime(availabilityId);
        }
        return entity;
    }

    @Override
    public List<RoomDTO> entityListToDTOList(List<RoomEntity> roomEntities) {
        List<RoomDTO> dtoList = new ArrayList<>();
        if (roomEntities == null) {
            return null;
        }
        for(RoomEntity roomEntity : roomEntities){
            dtoList.add(entityToDTO(roomEntity));
        }
        return dtoList;
    }

    @Override
    public List<RoomEntity> dtoListTOEntityList(List<RoomDTO> roomDTOS) {
        List<RoomEntity> entityList = new ArrayList<>();
        if (roomDTOS == null) {
            return null;
        }
        for(RoomDTO roomDTO : roomDTOS){
            entityList.add(dtoToEntity(roomDTO));
        }
        return entityList;
    }

    @Override
    public RoomEntity requestDTOToEntity(RoomRequestDTO dto) {
        RoomEntity entity = new RoomEntity();
        //entity.setHotelEntity(dto.getHotelEntity());
        entity.setPrice(dto.getPrice());
        entity.setRoomType(dto.getRoomType());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCreationDate(dto.getCreationDate());
        /*List<ReservationEntity> reservationId = reservationMapper.requestDtoListTOEntityList(dto.getReservation());
        if (reservationId != null) {
            entity.setReservation(reservationId);
        }

         */
        List<AvailabilityEntity> availabilityId = availabilityMapper.requestDtoListTOEntityList(dto.getCheckInTime());
        if (availabilityId != null) {
            entity.setCheckInTime(availabilityId);
        }

        return entity;
    }

    @Override
    public List<RoomEntity> requestDtoListTOEntityList(List<RoomRequestDTO> roomRequestDTOS) {
        List<RoomEntity> entityList = new ArrayList<>();
        if (roomRequestDTOS == null) {
            return null;
        }
        for(RoomRequestDTO roomRequestDTO : roomRequestDTOS){
            entityList.add(requestDTOToEntity(roomRequestDTO));
        }
        return entityList;
    }

    @Override
    public RoomEntity requestDtoToExistEntity(RoomEntity entity, RoomRequestDTO roomRequestDTO) {
        //entity.setHotelEntity(roomRequestDTO.getHotelEntity());
        entity.setPrice(roomRequestDTO.getPrice());
        entity.setRoomType(roomRequestDTO.getRoomType());
       /* List<ReservationEntity> reservationId = reservationMapper.requestDtoListTOEntityList(roomRequestDTO.getReservation());
        if (reservationId != null) {
            entity.setReservation(reservationId);
        }

        */
        List<AvailabilityEntity> availabilityId = availabilityMapper.requestDtoListTOEntityList(roomRequestDTO.getCheckInTime());
        if (availabilityId != null) {
            entity.setCheckInTime(availabilityId);
        }
        return entity;
    }

    @Override
    public PageDTO<RoomDTO> pageEntityToPageDTO(Page<RoomEntity> roomEntities) {
        PageDTO<RoomDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(roomEntities.getTotalPages());
        pageDTO.setSort(roomEntities.getSort());
        pageDTO.setSize(roomEntities.getSize());
        pageDTO.setNumber(roomEntities.getNumber());
        pageDTO.setHasContent(roomEntities.hasContent());
        pageDTO.setContent(entityListToDTOList(roomEntities.getContent()));
        pageDTO.setTotalElements(roomEntities.getTotalElements());

        return pageDTO;
    }
}
